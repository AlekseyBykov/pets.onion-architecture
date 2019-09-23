//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.User;

import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
public interface UserRegistry {
    Optional<User> findByLogin(String login);
}
