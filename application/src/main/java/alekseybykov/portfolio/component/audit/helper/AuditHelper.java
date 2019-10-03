//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.audit.helper;

import alekseybykov.portfolio.component.entities.Audit;
import alekseybykov.portfolio.component.entities.Auditable;
import alekseybykov.portfolio.component.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

import static java.time.ZonedDateTime.now;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-02
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuditHelper {

    private static final String AUDIT_PROPERTY_NAME = "audit";

    public static void embedAudit(Auditable entity, Audit audit, Object[] currentState, int auditPropertyIndex) {
        currentState[auditPropertyIndex] = audit;
        entity.setAudit(audit);
    }

    public static int getAuditPropertyIndexByName(String[] propertiesNames) {
        return Arrays.asList(propertiesNames).indexOf(AUDIT_PROPERTY_NAME);
    }

    public static boolean isNotAuditor(Object entity) {
        return !(entity instanceof Auditable);
    }

    public static Audit getDefaultAudit() {
        final String user = "admin";
        User admin = User.builder().id(NumberUtils.LONG_MINUS_ONE)
                .login(user).firstName(user).middleName(user).lastName(user)
                .build();
        return Audit.builder()
                .dateCreate(now())
                .userCreate(admin)
                .dateUpdate(now())
                .userUpdate(admin)
                .build();
    }
}
