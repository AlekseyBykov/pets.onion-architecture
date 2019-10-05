//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Getter
@RequiredArgsConstructor
public enum Errors {
    WHITEPAPPER_NOT_FOUND("Whitepapper not found"),
    SCOPE_NOT_FOUND("Scope not found");

    private final String name;
}
