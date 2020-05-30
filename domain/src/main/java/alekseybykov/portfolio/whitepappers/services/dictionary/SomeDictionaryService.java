package alekseybykov.portfolio.whitepappers.services.dictionary;

import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;

import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 05.10.2019
 */
public interface SomeDictionaryService {

    List<SomeDictionary> findAll();

    SomeDictionary findById(Long id);
}
