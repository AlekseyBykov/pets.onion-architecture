package alekseybykov.portfolio.whitepappers.repositories;

import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
import alekseybykov.portfolio.whitepappers.registries.WhitepapperRegistry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Repository
public interface WhitepapperRepository extends WhitepapperRegistry, JpaRepository<Whitepapper, Long> {

    @Override
    @Query(value = "select w from Whitepapper w ", countQuery = "select count(w) from Whitepapper w ")
    Page<Whitepapper> findAllWhitepappers(Pageable pageable);

    @Override
    @Query(value = "select w from Whitepapper w where w.id = :id ")
    Optional<Whitepapper> findById(@Param("id") Long id);

    @Override
    @Modifying
    @Query(value = "delete from Whitepapper w where w.id in (:ids) ")
    void deleteByIds(@Param("ids") Collection<Long> ids);
}
