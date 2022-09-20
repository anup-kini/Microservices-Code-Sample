package com.anup.rest.webservices.restfulwebservices.exception;

public class UserNotFoundException extends RuntimeException {
	
	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}