package com.cg.ofr.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ FlatNotFoundException.class })
	public final ResponseEntity<?> handleUserNotFoundException(FlatNotFoundException ex, WebRequest req) 
	{
		System.out.println("Inside ResponseEntityExceptionHandler() of FlatNotFoundException");
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(),
				"The Customer details requested are not present");
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);

	}
	
}
