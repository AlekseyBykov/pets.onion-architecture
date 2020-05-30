package alekseybykov.portfolio.whitepappers.services.user;

import alekseybykov.portfolio.whitepappers.entities.User;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
public interface UserService {
    User findByLogin(String login);
}
