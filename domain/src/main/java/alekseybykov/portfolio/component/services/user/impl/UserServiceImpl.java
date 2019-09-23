//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.user.impl;

import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.component.registries.UserRegistry;
import alekseybykov.portfolio.component.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRegistry userRegistry;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByLogin(String login) {
        return userRegistry.findByLogin(login).orElseThrow(EntityNotFoundException::new);
    }
}
