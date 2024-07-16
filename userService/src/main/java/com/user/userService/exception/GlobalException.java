package com.user.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ApiResponse> resourseNotFound(UserException userException) {

		String msg = userException.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMsg(msg);
		response.setStatus(true);
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
}
