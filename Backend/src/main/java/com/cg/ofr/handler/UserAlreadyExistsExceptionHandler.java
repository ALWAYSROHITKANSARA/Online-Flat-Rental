package com.cg.ofr.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.UserAlreadyExistsException;


@RestControllerAdvice
public class UserAlreadyExistsExceptionHandler {
	@Autowired
	private JSONObjects obj;
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleLandlordNotFoundException(UserAlreadyExistsException exe)
	{
		obj.setError(exe.getMessage());
		ResponseEntity<Object> retvalue=new ResponseEntity<Object>(obj,HttpStatus.NOT_FOUND);
		return retvalue;
	}
}