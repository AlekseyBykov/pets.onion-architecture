package alekseybykov.portfolio.whitepappers.service.user.impl;

import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.service.user.SecurityService;
import alekseybykov.portfolio.whitepappers.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
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
