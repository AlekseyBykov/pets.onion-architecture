//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.metadata.impl;

import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import alekseybykov.portfolio.component.services.metadata.WhitepapperMetadataService;
import alekseybykov.portfolio.component.services.validator.Action;
import alekseybykov.portfolio.component.services.validator.WhitepapperMetadataValidator;
import alekseybykov.portfolio.component.services.whitepapper.WhitePapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Service
@RequiredArgsConstructor
public class WhitepapperMetadataServiceImpl implements WhitepapperMetadataService {

    private final WhitepapperMetadataRegistry registry;
    private final WhitePapperService documentService;
    private final WhitepapperMetadataValidator validator;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public WhitePapperMetadata save(WhitePapperMetadata whitePapperMetadata, Long id) {
        WhitePapper whitePapper = documentService.getById(id);
        whitePapperMetadata.setId(whitePapper.getWhitePapperMetadata().getId());
        whitePapperMetadata.setWhitePapper(whitePapper);

        validator.validate(whitePapperMetadata, Action.UPDATE);

        return registry.save(whitePapperMetadata);
    }
}
