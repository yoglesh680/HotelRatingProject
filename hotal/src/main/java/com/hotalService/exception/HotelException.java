package com.hotalService.exception;

public class HotelException extends RuntimeException {

	public HotelException(String s) {
		super(s);
	}

	public HotelException() {
		super("Resource not Found!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
