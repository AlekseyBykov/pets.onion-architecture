//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.metadata.impl;

import alekseybykov.portfolio.component.entities.Whitepapper;
import alekseybykov.portfolio.component.entities.WhitepapperMetadata;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import alekseybykov.portfolio.component.services.metadata.WhitepapperMetadataService;
import alekseybykov.portfolio.component.services.validator.Action;
import alekseybykov.portfolio.component.services.validator.WhitepapperMetadataValidator;
import alekseybykov.portfolio.component.services.whitepapper.WhitepapperService;
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
    private final WhitepapperService whitepapperService;
    private final WhitepapperMetadataValidator validator;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public WhitepapperMetadata save(WhitepapperMetadata whitepapperMetadata, Long id) {
        Whitepapper whitepapper = whitepapperService.getById(id);
        whitepapperMetadata.setId(whitepapper.getWhitepapperMetadata().getId());
        whitepapperMetadata.setWhitepapper(whitepapper);

        validator.validate(whitepapperMetadata, Action.UPDATE);

        return registry.save(whitepapperMetadata);
    }
}
