package alekseybykov.portfolio.whitepappers.exceptions;

public class WorkWithFilesException extends RuntimeException {
    public WorkWithFilesException(String message) {
        super(message);
    }

    public WorkWithFilesException(String message, Throwable cause) {
        super(message, cause);
    }
}
