//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories.custom;

import alekseybykov.portfolio.component.entities.Audit;
import alekseybykov.portfolio.component.registries.AuditRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static java.lang.String.format;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
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
