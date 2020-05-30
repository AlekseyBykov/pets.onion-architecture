package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
public interface WhitepapperMetadataRegistry {

    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata);

    Optional<WhitepapperMetadata> findExistingWhitepapperMetadata(Long id,
                                                                  String registrationNumber,
                                                                  LocalDate registrationDate);
}
