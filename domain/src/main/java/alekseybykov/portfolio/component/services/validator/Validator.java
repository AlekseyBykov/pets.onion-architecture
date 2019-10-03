//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.services.validator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public abstract class Validator<T> {

    protected abstract void validate(T entity, Action action, Collection<String> errors);

    public void validate(T target, Action action) {
        ArrayList<String> errors = new ArrayList<>();
        validate(target, action, errors);
        if (!errors.isEmpty()) {
            throw new ValidationException(getClass().getName(), errors);
        }
    }
}
