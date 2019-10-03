//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.metadata;

import alekseybykov.portfolio.component.entities.WhitePapperMetadata;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface WhitepapperMetadataService {
    WhitePapperMetadata save(WhitePapperMetadata whitePapperMetadata, Long id);
}
