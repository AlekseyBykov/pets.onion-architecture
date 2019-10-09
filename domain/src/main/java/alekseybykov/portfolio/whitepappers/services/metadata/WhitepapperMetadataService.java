//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.metadata;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface WhitepapperMetadataService {
    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata, Long id);
}
