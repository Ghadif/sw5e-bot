package com.ghadif.exception;

import java.util.Objects;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class GenericRuntimeException extends RuntimeException {

    public GenericRuntimeException() {
        super();
    }

    public GenericRuntimeException(String message) {
        super(message);
    }

    public GenericRuntimeException(String message, Object... args) {
        super(String.format(message, args));
    }
}
