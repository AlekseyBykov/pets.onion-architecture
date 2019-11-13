package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;

import java.time.LocalDate;
import java.util.Optional;

public interface WhitepapperMetadataRegistry {

    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata);

    Optional<WhitepapperMetadata> findExistingWhitepapperMetadata(Long id,
                                                                  String registrationNumber,
                                                                  LocalDate registrationDate);
}
