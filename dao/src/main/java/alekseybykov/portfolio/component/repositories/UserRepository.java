//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.registries.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
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
