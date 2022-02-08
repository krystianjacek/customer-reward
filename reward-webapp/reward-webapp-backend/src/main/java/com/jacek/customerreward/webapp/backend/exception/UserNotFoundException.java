package com.jacek.customerreward.webapp.backend.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -179004722235448841L;
	
	public UserNotFoundException(final String message) {
		super(message);
	}
	
	public UserNotFoundException(final Throwable cause) {
		super(cause);
	}
	
	public UserNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
