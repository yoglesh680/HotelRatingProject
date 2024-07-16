package com.user.userService.exception;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private String msg;
	private boolean status;
	private HttpStatus httpStatus;

	public ApiResponse() {
		super();
	}

	public ApiResponse(String msg, boolean status, HttpStatus httpStatus) {
		super();
		this.msg = msg;
		this.status = status;
		this.httpStatus = httpStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "ApiResponse [msg=" + msg + ", status=" + status + ", httpStatus=" + httpStatus + "]";
	}

}
