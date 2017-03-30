package org.cvetkov.martin.controller;

import org.cvetkov.martin.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice()
@RestController 
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage invalidArgument(MethodArgumentTypeMismatchException e) {
		return new ErrorMessage("Ivalid data for size query string.");
	}


}