//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.SomeDictionary;
import alekseybykov.portfolio.component.registries.SomeDictionaryRegistry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
public interface SomeDictionaryRepository extends SomeDictionaryRegistry, JpaRepository<SomeDictionary, Long> {

    @Override
    List<SomeDictionary> findAll();

    @Override
    List<SomeDictionary> findAll(Sort sort);

    @Override
    Optional<SomeDictionary> findById(Long id);
}
