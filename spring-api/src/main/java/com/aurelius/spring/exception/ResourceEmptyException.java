package com.aurelius.spring.exception;

public class ResourceEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ERROR_MESSAGE = "The url path is valid but no resource is found";

    public ResourceEmptyException() {
	super(DEFAULT_ERROR_MESSAGE);
    }

    public ResourceEmptyException(String message) {
	super(message);
    }

    public ResourceEmptyException(String message, Exception e) {
	super(message, e);
    }

    public ResourceEmptyException(Exception e) {
	super(e);
    }
}
