//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.dictionary.impl;

import alekseybykov.portfolio.component.entities.SomeDictionary;
import alekseybykov.portfolio.component.enums.Errors;
import alekseybykov.portfolio.component.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.component.registries.SomeDictionaryRegistry;
import alekseybykov.portfolio.component.services.dictionary.SomeDictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-05
 */
@Service
@RequiredArgsConstructor
public class SomeDictionaryServiceImpl implements SomeDictionaryService {

    private final SomeDictionaryRegistry registry;

    @Override
    @Transactional(readOnly = true)
    public List<SomeDictionary> findAll() {
        return registry.findAll(sortByIdAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public SomeDictionary findById(Long id) {
        return registry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Errors.DICTIONARY_ITEM_NOT_FOUND.getName()));
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
}
