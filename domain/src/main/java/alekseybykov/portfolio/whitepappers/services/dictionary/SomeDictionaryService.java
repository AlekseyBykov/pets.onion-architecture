package alekseybykov.portfolio.whitepappers.services.dictionary;

import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;

import java.util.List;

public interface SomeDictionaryService {

    List<SomeDictionary> findAll();

    SomeDictionary findById(Long id);
}
