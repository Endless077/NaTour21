package com.natour.Server.exception;

import org.springframework.http.HttpStatus;

public class RequestApiException extends RuntimeException {

	private HttpStatus status;
	
	//Constructor
	public RequestApiException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public RequestApiException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}
	
	/*********************************************************************************************/
	
	//RunTimeException
//	public RequestApiException(String message) {
//		super(message);
//	}
//	
//	public RequestApiException(String message, Throwable cause) {
//		super(message, cause);
//	}

	/*********************************************************************************************/
	
	//Getter e Setter
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
