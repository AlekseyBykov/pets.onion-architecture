package alekseybykov.portfolio.whitepappers.repositories;

import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.registries.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
@Repository
public interface UserRepository extends UserRegistry, JpaRepository<User, Long> {
    @Query(value =
            "select distinct u " +
            "from User u " +
            "where lower(u.login) = lower(:login) "
    )
    Optional<User> findByLogin(@Param("login") String login);
}
