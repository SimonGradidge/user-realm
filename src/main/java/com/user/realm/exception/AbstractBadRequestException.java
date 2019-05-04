package com.user.realm.exception;

public class AbstractBadRequestException extends RuntimeException {

    private static final long serialVersionUID = 7394931306494602002L;

    public AbstractBadRequestException(String message) {
        super(message);
    }

    public AbstractBadRequestException() {
        super();
    }

    public AbstractBadRequestException(Throwable cause) {
        super(cause);
    }

    public AbstractBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
