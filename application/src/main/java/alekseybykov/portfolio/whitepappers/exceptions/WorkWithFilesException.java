package alekseybykov.portfolio.whitepappers.exceptions;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
public class WorkWithFilesException extends RuntimeException {
    public WorkWithFilesException(String message) {
        super(message);
    }

    public WorkWithFilesException(String message, Throwable cause) {
        super(message, cause);
    }
}
