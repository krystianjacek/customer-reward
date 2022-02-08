package com.jacek.customerreward.webapp.backend.controller.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jacek.customerreward.webapp.backend.exception.UserNotFoundException;

@ControllerAdvice
@Order(1) //in case there are more exception handlers
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseExceptionHandler.class);
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleUserNotFoundException(final UserNotFoundException e, final WebRequest request) {
		this.logErrorException(HttpStatus.BAD_REQUEST.value(), e);
		return this.handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleUnknownException(final Exception e, final WebRequest request) {
		this.logErrorException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
		return this.handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	private void logErrorException(final long httpCode, final Exception exception) {
		
		LOGGER.error(
				"RestResponseException " +
						"exceptionType: {}, httpCode: {}, reason: {}",
				exception.getClass().getSimpleName(),
				httpCode,
				exception.getMessage());
	}
}
