package com.aurelius.spring.exception;

public class ThirdPartyHttpException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThirdPartyHttpException(String message) {
	super(message);
    }

    public ThirdPartyHttpException(String message, Exception e) {
	super(message, e);
    }

    public ThirdPartyHttpException(Exception e) {
	super(e);
    }
}
