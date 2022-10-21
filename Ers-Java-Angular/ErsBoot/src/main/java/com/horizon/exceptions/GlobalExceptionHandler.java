package com.horizon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> exception(RecordNotFoundException exception) {
		return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	}
}
