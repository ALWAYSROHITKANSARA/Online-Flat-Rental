package com.cg.ofr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.UserAlreadyExistsException;


@RestControllerAdvice
public class UserAlreadyExistsExceptionHandler {
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> handleLandlordNotFoundException(UserAlreadyExistsException exe)
	{
		ResponseEntity<String> retvalue=new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
		return retvalue;
	}
}
