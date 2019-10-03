//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.service.user.impl;

import alekseybykov.portfolio.component.entities.User;
import alekseybykov.portfolio.component.service.user.SecurityService;
import alekseybykov.portfolio.component.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final UserService userService;

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (isNull(auth)) {
            return User.builder().id(NumberUtils.LONG_MINUS_ONE).build();
        }

        String currentPrincipalName = auth.getName();
        return userService.findByLogin(currentPrincipalName);
    }
}
