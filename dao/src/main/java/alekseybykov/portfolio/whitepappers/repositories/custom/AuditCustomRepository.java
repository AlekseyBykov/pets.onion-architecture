package alekseybykov.portfolio.whitepappers.repositories.custom;

import alekseybykov.portfolio.whitepappers.entities.Audit;
import alekseybykov.portfolio.whitepappers.registries.AuditRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static java.lang.String.format;

/**
 * @author Aleksey Bykov
 * @since 24.09.2019
 */
@Repository
@RequiredArgsConstructor
public class AuditCustomRepository implements AuditRegistry {

    private final EntityManager entityManager;

    @Override
    public Audit findAudit(String entityName, Long entityId) {
        Query query = entityManager.createQuery(
                format("select e.audit from %s e where e.id = %d", entityName, entityId));
        return (Audit)query.getSingleResult();
    }
}
