//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.service.whitepapper.impl;

import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.registries.WhitePapperRegistry;
import alekseybykov.portfolio.component.service.whitepapper.WhitepapperService;
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
public class WhitepapperServiceImpl implements WhitepapperService {

    private final WhitePapperRegistry whitePapperRegistry;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WhitePapper createWhitePapper(WhitePapper whitePapper) {
        WhitePapper saved = whitePapperRegistry.save(whitePapper);
        return saved;
    }
}
