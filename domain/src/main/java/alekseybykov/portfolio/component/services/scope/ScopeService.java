//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.scope;

import alekseybykov.portfolio.component.entities.Scope;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
public interface ScopeService {
    List<Scope> findAll();

    Scope findById(Long id);
}
