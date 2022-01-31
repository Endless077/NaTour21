package com.natour.Server.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestApiHandler {
	
	@ExceptionHandler(value = {RequestApiException.class})
	public ResponseEntity<Object> handleApiRequestException(RequestApiException e) {
		//1. Create payload containing exception details
		HttpStatus status = e.getStatus();
		ExceptionCustom apiException = new ExceptionCustom(
				e.getMessage(),
				e,
				status,
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		//2. Return response entity
		return new ResponseEntity<>(apiException, status);
	}
}
