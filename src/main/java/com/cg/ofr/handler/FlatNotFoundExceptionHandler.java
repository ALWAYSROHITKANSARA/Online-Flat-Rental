package com.cg.ofr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.FlatNotFoundException;


@RestControllerAdvice
public class FlatNotFoundExceptionHandler {

	@ExceptionHandler(FlatNotFoundException.class)
	public ResponseEntity<String>handleExceptionNotFound(FlatNotFoundException cnfe) {
		ResponseEntity<String> entity = new ResponseEntity<String>(cnfe.getMessage(), HttpStatus.NOT_FOUND);
		return entity;
	}
}
