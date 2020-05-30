package alekseybykov.portfolio.whitepappers.repositories;

import alekseybykov.portfolio.whitepappers.entities.WhitepapperMetadata;
import alekseybykov.portfolio.whitepappers.registries.WhitepapperMetadataRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
@Repository
public interface WhitepapperMetadataRepository extends WhitepapperMetadataRegistry, JpaRepository<WhitepapperMetadata, Long> {
    @Query(value = "select wm " +
            "from WhitepapperMetadata wm " +
            "where wm.registrationNumber = :registration_number " +
            "and wm.registrationDate = :registration_date " +
            "and wm.whitepapper.id <> :id"
    )
    Optional<WhitepapperMetadata> findExistingWhitepapperMetadata(@Param("id") Long id,
                                                                  @Param("registration_number") String registrationNumber,
                                                                  @Param("registration_date") LocalDate registrationDate
    );
}
