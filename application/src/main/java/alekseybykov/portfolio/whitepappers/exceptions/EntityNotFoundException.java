package alekseybykov.portfolio.whitepappers.exceptions;

/**
 * @author Aleksey Bykov
 * @since 03.10.2019
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() { }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
