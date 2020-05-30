package alekseybykov.portfolio.whitepappers.exceptions;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
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
