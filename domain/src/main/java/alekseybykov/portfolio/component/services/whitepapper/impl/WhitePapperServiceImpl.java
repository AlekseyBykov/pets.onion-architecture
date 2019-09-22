//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.whitepapper.impl;

import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.registries.WhitePapperRegistry;
import alekseybykov.portfolio.component.services.whitepapper.WhitePapperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WhitePapperServiceImpl implements WhitePapperService {

    private final WhitePapperRegistry whitePapperRegistry;

    @Override
    public List<WhitePapper> findAll() {
        return whitePapperRegistry.findAll();
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        whitePapperRegistry.deleteByIds(ids);
    }
}
