package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.WhitePapper;

import java.util.Collection;
import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface WhitePapperRegistry {

    List<WhitePapper> findAll();

    void deleteByIds(Collection<Long> ids);
}
