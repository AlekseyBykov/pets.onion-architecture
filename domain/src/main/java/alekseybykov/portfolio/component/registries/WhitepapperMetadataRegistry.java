//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.WhitePapperMetadata;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface WhitepapperMetadataRegistry {

    WhitePapperMetadata save(WhitePapperMetadata whitePapperMetadata);

    Optional<WhitePapperMetadata> findExistingWhitePapperMetadata(Long id,
                                                                  String registrationNumber,
                                                                  LocalDate registrationDate);
}
