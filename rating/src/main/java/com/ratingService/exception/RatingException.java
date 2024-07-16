package com.ratingService.exception;

public class RatingException extends RuntimeException {

	public RatingException(String s) {
		super(s);
	}

	public RatingException() {
		super("Resource not Found!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
