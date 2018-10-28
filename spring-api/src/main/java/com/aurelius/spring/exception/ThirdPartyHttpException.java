package com.aurelius.spring.exception;

public class ThirdPartyHttpException extends RuntimeException {
    public ThirdPartyHttpException(Exception e) {
	super(e);
    }
}
