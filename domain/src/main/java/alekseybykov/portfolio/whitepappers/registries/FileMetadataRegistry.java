package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.FileMetadata;

import java.util.List;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 06.10.2019
 */
public interface FileMetadataRegistry {

    FileMetadata save(FileMetadata fileMetadata);

    List<FileMetadata> getAllByStorage(FileMetadata.Storage storage);

    Optional<FileMetadata> getByWhitepapperId(Long id);
}
