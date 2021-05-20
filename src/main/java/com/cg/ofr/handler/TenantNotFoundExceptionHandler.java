package com.cg.ofr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.TenantNotFoundException;

@RestControllerAdvice
public class TenantNotFoundExceptionHandler {
	
	@ExceptionHandler(TenantNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(TenantNotFoundException tnfe)
	{
		ResponseEntity<String> rentity=new ResponseEntity<String>(tnfe.toString(),HttpStatus.NOT_FOUND);
		return rentity;
	}

}
