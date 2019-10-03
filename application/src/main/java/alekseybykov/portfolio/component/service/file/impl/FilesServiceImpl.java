//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.service.file.impl;

import alekseybykov.portfolio.component.entities.FileMetadata;
import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.exceptions.WorkWithFilesException;
import alekseybykov.portfolio.component.registries.FileMetadataRegistry;
import alekseybykov.portfolio.component.services.file.FilesService;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
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
    public void saveFile(String fileName, WhitePapper whitePapper, InputStream stream) {
        byte[] bytes;
        try {
            bytes = IOUtils.toByteArray(stream);
            String uuid = UUID.randomUUID().toString();
            Files.write(Paths.get(filesPath, uuid).toAbsolutePath(), bytes);
            FileMetadata fileMetadata = FileMetadata.builder()
                    .fileName(fileName)
                    .uuid(uuid)
                    .storage(FileMetadata.Storage.LOCAL)
                    .whitePapper(whitePapper)
                    .build();
            fileMetadataRegistry.save(fileMetadata);
        } catch (IOException e) {
            throw new WorkWithFilesException("Error while saving file", e);
        }
    }
}
