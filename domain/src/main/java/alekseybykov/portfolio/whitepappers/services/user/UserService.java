package alekseybykov.portfolio.whitepappers.services.user;

import alekseybykov.portfolio.whitepappers.entities.User;

public interface UserService {
    User findByLogin(String login);
}
