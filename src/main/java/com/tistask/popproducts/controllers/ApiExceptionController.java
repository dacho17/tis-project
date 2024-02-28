package com.tistask.popproducts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tistask.popproducts.dtos.ResponseObject;
import com.tistask.popproducts.exceptions.ApiBadRequestException;
import com.tistask.popproducts.exceptions.DbException;

@RestControllerAdvice
public class ApiExceptionController {

	private static final String errorInRequest = "Please check that the information you provided has been entered correctly.";
	private static final String internalServerError = "Internal Server Error occurred.";
	
	private static final Logger logger = LoggerFactory.getLogger(ApiExceptionController.class);
		
	@ExceptionHandler
	public ResponseEntity<ResponseObject<?>> handleException(ApiBadRequestException exc) {
		logger.warn(String.format("Exception of %s occured, API is returning %s response.", exc.getClass().toString(), HttpStatus.BAD_REQUEST));
		return new ResponseEntity<>(new ResponseObject<>(errorInRequest, exc.getMessage(), true), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseObject<?>> handleException(DbException exc) {
		logger.warn(String.format("Exception of %s occured, API is returning %s response.", exc.getClass().toString(), HttpStatus.INTERNAL_SERVER_ERROR));
		
		return new ResponseEntity<>(new ResponseObject<>(internalServerError, exc.getMessage(), true), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
