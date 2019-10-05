//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.Scope;
import alekseybykov.portfolio.component.registries.ScopeRegistry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
public interface ScopeRepository extends ScopeRegistry, JpaRepository<Scope, Long> {

    @Override
    List<Scope> findAll();

    @Override
    List<Scope> findAll(Sort sort);

    @Override
    Optional<Scope> findById(Long id);
}
