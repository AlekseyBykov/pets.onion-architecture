package alekseybykov.portfolio.whitepappers.e2e.audit;

import alekseybykov.portfolio.whitepappers.audit.helper.AuditHelper;
import alekseybykov.portfolio.whitepappers.e2e.base.IntegrationTestsBaseClass;
import alekseybykov.portfolio.whitepappers.entities.Audit;
import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.entities.Whitepapper;
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
 * @author Aleksey Bykov
 * @since 24.09.2019
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
                .dateUpdate(updatedAt)
                .userCreate(admin)
                .build();

        Whitepapper whitepapper = Whitepapper.builder()
                .name("whitepapper")
                .audit(audit)
                .build();

        em.persist(whitepapper);
        em.flush();
        em.clear();

        Long createdWhitepapperId = whitepapper.getId();
        assertNotNull(createdWhitepapperId);

        Whitepapper createdWhitepapper = em.find(Whitepapper.class, createdWhitepapperId);
        assertNotNull(createdWhitepapper);

        Audit createdWhitepapperAudit = createdWhitepapper.getAudit();
        assertNotNull(createdWhitepapperAudit);

        User createdWhitepapperUser = createdWhitepapperAudit.getUserCreate();
        assertNotNull(createdWhitepapperUser);

        assertEquals(createdWhitepapperUser.getId(), admin.getId());
        assertEquals(createdWhitepapperUser.getLastName(), admin.getLastName());
        assertEquals(createdWhitepapperUser.getFirstName(), admin.getFirstName());
        assertEquals(createdWhitepapperUser.getMiddleName(), admin.getMiddleName());
        assertEquals(createdWhitepapperAudit.getDateCreate().toInstant(), createdAt.toInstant());

        createdWhitepapperAudit.setDateUpdate(updatedAt);
        createdWhitepapper.setAudit(createdWhitepapperAudit);

        em.persist(createdWhitepapper);
        em.flush();
        em.clear();

        Long updatedWhitepapperId = createdWhitepapper.getId();
        assertNotNull(updatedWhitepapperId);

        Whitepapper updatedWhitepapper = em.find(Whitepapper.class, updatedWhitepapperId);
        assertNotNull(updatedWhitepapper);

        Audit updatedWhitepapperAudit = updatedWhitepapper.getAudit();
        assertNotNull(updatedWhitepapperAudit);

        User updatedWhitepapperUser = updatedWhitepapperAudit.getUserCreate();
        assertNotNull(updatedWhitepapperUser);

        assertEquals(updatedWhitepapperUser.getId(), admin.getId());
        assertEquals(updatedWhitepapperUser.getLastName(), admin.getLastName());
        assertEquals(updatedWhitepapperUser.getFirstName(), admin.getFirstName());
        assertEquals(updatedWhitepapperUser.getMiddleName(), admin.getMiddleName());
        assertEquals(updatedWhitepapperAudit.getDateCreate().toInstant(), createdAt.toInstant());
        assertEquals(updatedWhitepapperAudit.getDateUpdate().toInstant(), updatedAt.toInstant());
        assertNotEquals(updatedWhitepapperAudit.getDateUpdate().toInstant(), createdAt.toInstant());
    }
}
