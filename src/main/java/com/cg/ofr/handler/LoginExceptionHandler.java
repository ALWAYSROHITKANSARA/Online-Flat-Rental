package com.cg.ofr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.LoginException;

@RestControllerAdvice
public class LoginExceptionHandler {
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<String> handleLandlordNotFoundException(LoginException exe)
	{
		ResponseEntity<String> retvalue=new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
		return retvalue;
	}
}
