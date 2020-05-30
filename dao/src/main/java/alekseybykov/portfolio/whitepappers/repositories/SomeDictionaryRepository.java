package alekseybykov.portfolio.whitepappers.repositories;

import alekseybykov.portfolio.whitepappers.entities.SomeDictionary;
import alekseybykov.portfolio.whitepappers.registries.SomeDictionaryRegistry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 05.10.2019
 */
public interface SomeDictionaryRepository extends SomeDictionaryRegistry, JpaRepository<SomeDictionary, Long> {

    @Override
    List<SomeDictionary> findAll();

    @Override
    List<SomeDictionary> findAll(Sort sort);

    @Override
    Optional<SomeDictionary> findById(Long id);
}
