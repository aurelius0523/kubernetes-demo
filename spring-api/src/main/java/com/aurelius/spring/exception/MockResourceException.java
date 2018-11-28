package com.aurelius.spring.exception;

public class MockResourceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MockResourceException(String message) {
	super(message);
    }

    public MockResourceException(String message, Exception e) {
	super(message, e);
    }

    public MockResourceException(Exception e) {
	super(e);
    }
}
