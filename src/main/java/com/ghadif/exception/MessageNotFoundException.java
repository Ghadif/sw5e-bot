package com.ghadif.exception;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class MessageNotFoundException extends GenericRuntimeException {

    public MessageNotFoundException() {
    }

    public MessageNotFoundException(String message) {
        super(message);
    }

    public MessageNotFoundException(String message, Object... args) {
        super(message, args);
    }
}
