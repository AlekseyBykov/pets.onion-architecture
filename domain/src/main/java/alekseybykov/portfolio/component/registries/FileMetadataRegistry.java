//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.FileMetadata;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface FileMetadataRegistry {
    FileMetadata save(FileMetadata fileMetadata);
}
