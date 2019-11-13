package alekseybykov.portfolio.whitepappers.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() { }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
