//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.exceptions;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() { }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
