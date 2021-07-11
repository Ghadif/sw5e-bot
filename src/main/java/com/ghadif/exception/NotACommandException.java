package com.ghadif.exception;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class NotACommandException extends GenericRuntimeException {

    public NotACommandException() {
    }

    public NotACommandException(String message) {
        super(message);
    }

    public NotACommandException(String message, Object... args) {
        super(message, args);
    }
}
