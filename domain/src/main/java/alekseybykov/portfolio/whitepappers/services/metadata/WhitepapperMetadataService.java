package alekseybykov.portfolio.whitepappers.services.metadata;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;

public interface WhitepapperMetadataService {
    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata, Long id);
}
