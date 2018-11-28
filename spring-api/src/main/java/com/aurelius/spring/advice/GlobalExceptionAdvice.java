package com.aurelius.spring.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aurelius.spring.constants.InternalErrorCode;
import com.aurelius.spring.exception.MockResourceException;
import com.aurelius.spring.facade.model.ServerErrorModel;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * Interceptor for all {@link RuntimeException} and {@link Exception} that is
     * not properly handled by the code, returning
     * {@link HttpStatus#INTERNAL_SERVER_ERROR} status code
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ RuntimeException.class, Exception.class })
    public ResponseEntity<ServerErrorModel> handleServerException(HttpServletRequest request, Exception e) {
	ServerErrorModel serverError = new ServerErrorModel(request.getRequestURI(), e.getMessage(),
		InternalErrorCode.UNHANDLED_SERVER_EXCEPTION.getErrorCode());

	return new ResponseEntity<ServerErrorModel>(serverError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles {@link MockResourceException}. This is a dev only exception and
     * should not happen outside of dev environment
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ MockResourceException.class })
    public ResponseEntity<ServerErrorModel> handleMockResourceException(HttpServletRequest request, Exception e) {
	ServerErrorModel serverError = new ServerErrorModel(request.getRequestURI(), e.getMessage(),
		InternalErrorCode.MOCK_RESOURCE_EXCEPTION.getErrorCode());
	// TODO also log error in console, since this is development only
	return new ResponseEntity<ServerErrorModel>(serverError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
