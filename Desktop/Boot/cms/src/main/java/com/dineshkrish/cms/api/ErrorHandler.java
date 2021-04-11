package com.dineshkrish.cms.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.dineshkrish.cms.exception.ApplicationError;
import com.dineshkrish.cms.exception.CustomerNotFoundException;

@RestController
@RestControllerAdvice
public class ErrorHandler {
	
	@Value("${api_doc_url}")
	private String details;
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest){
		
		ApplicationError error = new ApplicationError();
		error.setCode(404);
		error.setMessage(exception.getMessage());
		error.setDetails(details);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
