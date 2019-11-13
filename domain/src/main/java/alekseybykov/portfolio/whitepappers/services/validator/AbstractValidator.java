package alekseybykov.portfolio.whitepappers.services.validator;

import alekseybykov.portfolio.whitepappers.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractValidator<T> {

    protected abstract void validate(T entity, Action action, Collection<String> errors);

    public void validate(T target, Action action) {
        ArrayList<String> errors = new ArrayList<>();
        validate(target, action, errors);
        if (!errors.isEmpty()) {
            throw new ValidationException(getClass().getName(), errors);
        }
    }
}
