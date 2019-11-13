package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface SomeDictionaryRegistry {

    List<SomeDictionary> findAll(Sort sort);

    Optional<SomeDictionary> findById(Long id);
}
