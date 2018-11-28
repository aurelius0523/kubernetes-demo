package com.aurelius.spring.advice;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.aurelius.spring.constants.InternalErrorCode;
import com.aurelius.spring.facade.model.ServerErrorModel;

@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionAdviceTest {

    @InjectMocks
    private GlobalExceptionAdvice globalExceptionAdvice;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Test
    public void whenRuntimeExceptionIsThrown_ThenThrowAppropriateErrorMessages() {
	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setRequestURI("/customers");
	RuntimeException exception = new RuntimeException("runtimeException occured!");
	ResponseEntity<ServerErrorModel> responseEntity = globalExceptionAdvice.handleServerException(request,
		exception);

	assertEquals("/customers", responseEntity.getBody()
	    .getPath());
	assertEquals(InternalErrorCode.UNHANDLED_SERVER_EXCEPTION.getErrorCode(), responseEntity.getBody()
	    .getInternalErrorCode());
	assertEquals(exception.getMessage(), responseEntity.getBody()
	    .getDescription());
	assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void whenExceptionIsThrown_ThenThrowAppropriateErrorMessages() {
	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setRequestURI("/customers");
	Exception exception = new Exception("Exception occured!");
	ResponseEntity<ServerErrorModel> responseEntity = globalExceptionAdvice.handleServerException(request,
		exception);

	assertEquals("/customers", responseEntity.getBody()
	    .getPath());
	assertEquals(InternalErrorCode.UNHANDLED_SERVER_EXCEPTION.getErrorCode(), responseEntity.getBody()
	    .getInternalErrorCode());
	assertEquals(exception.getMessage(), responseEntity.getBody()
	    .getDescription());
	assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void whenMockResourceExceptionIsThrown_ThenThrowAppropriateErrorMessages() {
	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setRequestURI("/customers");
	Exception exception = new Exception("Exception occured!");
	ResponseEntity<ServerErrorModel> responseEntity = globalExceptionAdvice.handleMockResourceException(request,
		exception);

	assertEquals("/customers", responseEntity.getBody()
	    .getPath());
	assertEquals(InternalErrorCode.MOCK_RESOURCE_EXCEPTION.getErrorCode(), responseEntity.getBody()
	    .getInternalErrorCode());
	assertEquals(exception.getMessage(), responseEntity.getBody()
	    .getDescription());
	assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
