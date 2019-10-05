//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.dictionary;

import alekseybykov.portfolio.component.entities.SomeDictionary;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
public interface SomeDictionaryService {

    List<SomeDictionary> findAll();

    SomeDictionary findById(Long id);
}
