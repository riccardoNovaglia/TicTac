package ticsAndTacs.Game;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(Exception cause) {
        super(cause);
    }

    public IllegalMoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
