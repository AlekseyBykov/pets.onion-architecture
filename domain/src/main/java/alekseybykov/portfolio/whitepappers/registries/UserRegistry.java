package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.User;

import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
public interface UserRegistry {
    Optional<User> findByLogin(String login);
}
