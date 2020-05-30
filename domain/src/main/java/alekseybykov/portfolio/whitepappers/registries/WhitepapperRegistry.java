package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
public interface WhitepapperRegistry {

    Whitepapper save(Whitepapper whitepapper);

    Page<Whitepapper> findAllWhitepappers(Pageable pageable);

    void deleteByIds(Collection<Long> ids);

    Optional<Whitepapper> findById(Long id);
}
