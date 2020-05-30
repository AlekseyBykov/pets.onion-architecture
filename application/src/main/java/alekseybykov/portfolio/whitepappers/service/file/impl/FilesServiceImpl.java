package alekseybykov.portfolio.whitepappers.service.file.impl;

import alekseybykov.portfolio.whitepappers.entities.FileMetadata;
import alekseybykov.portfolio.whitepappers.entities.FileTransferObject;
import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import alekseybykov.portfolio.whitepappers.enums.FileFormat;
import alekseybykov.portfolio.whitepappers.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.whitepappers.exceptions.WorkWithFilesException;
import alekseybykov.portfolio.whitepappers.registries.FileMetadataRegistry;
import alekseybykov.portfolio.whitepappers.services.file.FilesService;
import io.minio.MinioClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static alekseybykov.portfolio.whitepappers.entities.FileMetadata.Storage.LOCAL;
import static alekseybykov.portfolio.whitepappers.entities.FileMetadata.Storage.MINIO;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FilesServiceImpl implements FilesService {

    @Value("${fileservice.storage.local.path}")
    private String filesPath;

    @Value("${fileservice.storage.minio.bucket}")
    private String bucketName;

    private final FileMetadataRegistry fileMetadataRegistry;
    private final MinioClient minioClient;

    @PostConstruct
    void init() {
        try {
            if (!minioClient.bucketExists(bucketName)) {
                minioClient.makeBucket(bucketName);
            }
        } catch (Exception e) {
            log.error("Error during MINIO initializing {}", e.getMessage());
        }

        try {
            Path localFilesPath = Paths.get(filesPath).toAbsolutePath();
            if (!Files.exists(localFilesPath)) {
                Files.createDirectory(localFilesPath);
            }
        } catch (Exception e) {
            log.error("Error during temp folder creating {}", e.getMessage());
        }
    }

    @Override
    public void saveFile(String fileName, Whitepapper whitepapper, InputStream stream) {
        byte[] bytes;
        try {
            bytes = IOUtils.toByteArray(stream);
            String uuid = UUID.randomUUID().toString();
            Files.write(Paths.get(filesPath, uuid).toAbsolutePath(), bytes);
            FileMetadata fileMetadata = FileMetadata.builder()
                .fileName(fileName)
                .uuid(uuid)
                .storage(LOCAL)
                .whitepapper(whitepapper)
                .build();
            fileMetadataRegistry.save(fileMetadata);
        } catch (IOException e) {
            throw new WorkWithFilesException("Error while saving file", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer moveAllFilesToTheCloud() {
        final List<String> uuids = new ArrayList<>();
        fileMetadataRegistry.getAllByStorage(LOCAL)
            .forEach(fileMetadata -> {
                try {
                    minioClient.putObject(
                        bucketName,
                        fileMetadata.getUuid(),
                        getFileStreamById(fileMetadata.getWhitepapper().getId()).getStream(),
                        FileFormat.DOCX.getName()
                    );
                    fileMetadata.setStorage(MINIO);
                    fileMetadataRegistry.save(fileMetadata);
                    uuids.add(fileMetadata.getUuid());
                } catch ( Exception e) {
                    log.error("Error occurred while moving the file to the foreign storage {}", e.getMessage());
                }
            });
        uuids.forEach(uuid -> {
            try {
                Files.delete(Paths.get(filesPath, uuid).toAbsolutePath());
            } catch (IOException e) {
                log.error("Error occurred while removing the file {}", e.getMessage());
            }
        });
        return uuids.size();
    }

    @Transactional(readOnly = true)
    public FileTransferObject getFileStreamById(@NonNull Long id) {
        FileMetadata fileMetadata = fileMetadataRegistry.getByWhitepapperId(id).orElseThrow(EntityNotFoundException::new);
        if (MINIO.equals(fileMetadata.getStorage())) {
            try {
                return FileTransferObject.builder()
                        .fileName(fileMetadata.getFileName())
                        .stream(minioClient.getObject(bucketName, fileMetadata.getUuid()))
                        .build();
            } catch (Exception e) {
                throw new WorkWithFilesException("Error occurred while getting the file from the cloud");
            }
        } else if (LOCAL.equals(fileMetadata.getStorage())) {
            try {
                return FileTransferObject.builder()
                        .fileName(fileMetadata.getFileName())
                        .stream(Files.newInputStream(Paths.get(filesPath, fileMetadata.getUuid()).toAbsolutePath()))
                        .build();
            } catch (IOException e) {
                throw new WorkWithFilesException("Error occurred while getting the file from the local storage");
            }
        } else {
            throw new WorkWithFilesException("Storage not found");
        }
    }
}
