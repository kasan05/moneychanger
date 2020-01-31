package com.resortworld.moneychanger.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MoneyExchangeExceptionHandler {

	@ExceptionHandler(ConverstionTypeNotFoundException.class)
	public ResponseEntity<ExceptionResponse > handleException(final Exception exception,
			final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.setErrorCode("001");
		response.callerURL(request.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	@ExceptionHandler(TypeMismatchException.class)
	public ResponseEntity<ExceptionResponse > handleTypeMisMatchException(final Exception exception,
			final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.callerURL(request.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
