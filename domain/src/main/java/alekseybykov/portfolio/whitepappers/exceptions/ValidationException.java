//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.exceptions;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public class ValidationException extends RuntimeException {
    private final Collection<String> errors;
    private final String validator;

    public ValidationException(String validator, Collection<String> errors) {
        super(errors.stream().collect(Collectors.joining("; ", validator + ": [", "]")));
        this.errors = errors;
        this.validator = validator;
    }

    public Collection<String> getErrors() {
        return errors;
    }

    public String getValidator() {
        return validator;
    }
}
