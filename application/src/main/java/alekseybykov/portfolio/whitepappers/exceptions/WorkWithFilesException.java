//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.exceptions;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
public class WorkWithFilesException extends RuntimeException {
    public WorkWithFilesException(String message) {
        super(message);
    }

    public WorkWithFilesException(String message, Throwable cause) {
        super(message, cause);
    }
}
