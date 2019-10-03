//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.e2e.audit;

import alekseybykov.portfolio.component.audit.helper.AuditHelper;
import alekseybykov.portfolio.component.e2e.IntegrationTestsBaseClass;
import alekseybykov.portfolio.component.entities.Audit;
import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.entities.WhitePapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Test for JPA events listener")
class AuditE2ETest extends IntegrationTestsBaseClass {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @DisplayName("Set the audit fields for the whitepapper manually and verify")
    void testSetAuditFieldsForWhitepapperManuallyAndCheck() {

        final ZonedDateTime createdAt = ZonedDateTime.parse("2019-09-22T10:24:33.267993+03:00[Europe/Moscow]");
        final ZonedDateTime updatedAt = ZonedDateTime.parse("2019-10-23T10:24:33.267993+03:00[Europe/Moscow]");

        User admin = AuditHelper.getDefaultAudit().getUserCreate();
        Audit audit = Audit.builder()
                .dateCreate(createdAt)
                .userCreate(admin)
                .build();

        WhitePapper whitePapper = WhitePapper.builder()
                .name("whitepapper")
                .audit(audit)
                .build();

        em.persist(whitePapper);
        em.flush();
        em.clear();

        Long createdWhitePapperId = whitePapper.getId();
        assertNotNull(createdWhitePapperId);

        WhitePapper createdWhitePapper = em.find(WhitePapper.class, createdWhitePapperId);
        assertNotNull(createdWhitePapper);

        Audit createdWhitePapperAudit = createdWhitePapper.getAudit();
        assertNotNull(createdWhitePapperAudit);

        User createdWhitePapperUser = createdWhitePapperAudit.getUserCreate();
        assertNotNull(createdWhitePapperUser);

        assertEquals(createdWhitePapperUser.getId(), admin.getId());
        assertEquals(createdWhitePapperUser.getLastName(), admin.getLastName());
        assertEquals(createdWhitePapperUser.getFirstName(), admin.getFirstName());
        assertEquals(createdWhitePapperUser.getMiddleName(), admin.getMiddleName());
        assertEquals(createdWhitePapperAudit.getDateCreate().toInstant(), createdAt.toInstant());

        createdWhitePapperAudit.setDateUpdate(updatedAt);
        createdWhitePapper.setAudit(createdWhitePapperAudit);

        em.persist(createdWhitePapper);
        em.flush();
        em.clear();

        Long updatedWhitePapperId = createdWhitePapper.getId();
        assertNotNull(updatedWhitePapperId);

        WhitePapper updatedWhitePapper = em.find(WhitePapper.class, updatedWhitePapperId);
        assertNotNull(updatedWhitePapper);

        Audit updatedWhitePapperAudit = updatedWhitePapper.getAudit();
        assertNotNull(updatedWhitePapperAudit);

        User updatedWhitePapperUser = updatedWhitePapperAudit.getUserCreate();
        assertNotNull(updatedWhitePapperUser);

        assertEquals(updatedWhitePapperUser.getId(), admin.getId());
        assertEquals(updatedWhitePapperUser.getLastName(), admin.getLastName());
        assertEquals(updatedWhitePapperUser.getFirstName(), admin.getFirstName());
        assertEquals(updatedWhitePapperUser.getMiddleName(), admin.getMiddleName());
        assertEquals(updatedWhitePapperAudit.getDateCreate().toInstant(), createdAt.toInstant());
        assertEquals(updatedWhitePapperAudit.getDateUpdate().toInstant(), updatedAt.toInstant());
        assertNotEquals(updatedWhitePapperAudit.getDateUpdate().toInstant(), createdAt.toInstant());
    }
}
