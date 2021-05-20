package com.cg.ofr.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.controller.LandlordController;
import com.cg.ofr.exception.LandlordNotFoundException;

@RestControllerAdvice
public class LandlordNotFoundExceptionHandler {
	static final  Logger LOGGER = LogManager.getLogger(LandlordNotFoundExceptionHandler.class);
	@ExceptionHandler(LandlordNotFoundException.class)
	public ResponseEntity<String> handleLandlordNotFoundException(LandlordNotFoundException exe)
	{
		LOGGER.warn("----EXCEPTION-->LandlordNotFoundException caught");
		ResponseEntity<String> retvalue=new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
		return retvalue;
	}
}
