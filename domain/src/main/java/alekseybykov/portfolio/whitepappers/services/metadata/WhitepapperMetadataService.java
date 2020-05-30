package alekseybykov.portfolio.whitepappers.services.metadata;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
public interface WhitepapperMetadataService {
    WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata, Long id);
}
