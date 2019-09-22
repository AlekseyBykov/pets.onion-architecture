//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.whitepapper;

import alekseybykov.portfolio.component.entities.WhitePapper;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface WhitePapperService {

    List<WhitePapper> findAll();

    void deleteByIds(List<Long> ids);
}
