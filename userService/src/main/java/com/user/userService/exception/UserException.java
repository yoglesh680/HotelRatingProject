package com.user.userService.exception;

public class UserException extends RuntimeException {

	public UserException() {
		super("Resource Not found on Server!......");
	}

	public UserException(String msg) {
		super(msg);
	}

}
