package com.cg.ofr.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.LandlordNotFoundException;

@RestControllerAdvice
public class LandlordNotFoundExceptionHandler {
	@Autowired
	private JSONObjects obj;
	static final  Logger LOGGER = LogManager.getLogger(LandlordNotFoundExceptionHandler.class);
	//Annotation for handling exceptions in specific handler classes and/or handler methods. 
	@ExceptionHandler(LandlordNotFoundException.class)
	public ResponseEntity<Object> handleLandlordNotFoundException(LandlordNotFoundException exe)
	{
		LOGGER.warn("----EXCEPTION-->LandlordNotFoundException caught");
		
		obj.setError(exe.getMessage());
		ResponseEntity<Object> retvalue=new ResponseEntity<Object>(obj,HttpStatus.NOT_FOUND);
		return retvalue;
	}
}