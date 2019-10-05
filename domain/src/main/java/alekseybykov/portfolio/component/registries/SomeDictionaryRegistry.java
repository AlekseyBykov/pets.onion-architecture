//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.registries;

import alekseybykov.portfolio.component.entities.SomeDictionary;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
public interface SomeDictionaryRegistry {

    List<SomeDictionary> findAll(Sort sort);

    Optional<SomeDictionary> findById(Long id);
}
