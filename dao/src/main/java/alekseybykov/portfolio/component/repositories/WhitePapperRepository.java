package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.registries.WhitePapperRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@Repository
public interface WhitePapperRepository extends WhitePapperRegistry, JpaRepository<WhitePapper, Long> {
    @Override
    @Modifying
    @Query(value = "delete " +
            "from WhitePapper w " +
            "where w.id in (:ids) "
    )
    void deleteByIds(@Param("ids") Collection<Long> ids);
}
