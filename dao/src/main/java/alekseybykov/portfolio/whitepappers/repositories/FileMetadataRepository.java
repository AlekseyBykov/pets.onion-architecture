package alekseybykov.portfolio.whitepappers.repositories;

import alekseybykov.portfolio.whitepappers.entities.FileMetadata;
import alekseybykov.portfolio.whitepappers.registries.FileMetadataRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileMetadataRepository extends FileMetadataRegistry, JpaRepository<FileMetadata, Long> {

    @Override
    List<FileMetadata> getAllByStorage(@Param("storage") FileMetadata.Storage storage);

    @Override
    Optional<FileMetadata> getByWhitepapperId(@Param("id") Long id);
}
