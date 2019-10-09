//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.registries;

import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
public interface WhitepapperRegistry {

    Whitepapper save(Whitepapper whitepapper);

    Page<Whitepapper> findAllWhitepappers(Pageable pageable);

    void deleteByIds(Collection<Long> ids);

    Optional<Whitepapper> findById(Long id);
}
