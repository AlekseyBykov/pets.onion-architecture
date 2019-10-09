//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.WhitepapperMetadata;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public interface WhitepapperMetadataRegistry {

    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata);

    Optional<WhitepapperMetadata> findExistingWhitepapperMetadata(Long id,
                                                                  String registrationNumber,
                                                                  LocalDate registrationDate);
}
