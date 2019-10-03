//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.FileMetadata;
import alekseybykov.portfolio.component.registries.FileMetadataRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Repository
public interface FileMetadataRepository extends FileMetadataRegistry, JpaRepository<FileMetadata, Long> { }
