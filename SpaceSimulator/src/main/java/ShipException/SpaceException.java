package ShipException;

public class SpaceException extends Exception {

    public SpaceException(String message) {
        super(message);
    }

    public SpaceException() {
        super("obstacle no null");
    }

    public SpaceException(String message, Throwable cause) {
        super(message, cause);
    }
}