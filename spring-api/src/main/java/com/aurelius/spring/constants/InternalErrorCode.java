package com.aurelius.spring.constants;

public enum InternalErrorCode {
    UNHANDLED_SERVER_EXCEPTION(9000), MOCK_RESOURCE_EXCEPTION(9100);
    private int errorCode;

    InternalErrorCode(int errorCode) {
	this.errorCode = errorCode;
    }

    public int getErrorCode() {
	return errorCode;
    }

    public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
    }
}
