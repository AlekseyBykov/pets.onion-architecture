package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.User;

import java.util.Optional;

public interface UserRegistry {
    Optional<User> findByLogin(String login);
}
