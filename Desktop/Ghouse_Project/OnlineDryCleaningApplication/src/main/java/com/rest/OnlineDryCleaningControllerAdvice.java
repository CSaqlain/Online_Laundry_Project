package com.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.EmptyEntityListException;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityNotFoundException;
import com.exception.EntityUpdationException;

@RestControllerAdvice
public class OnlineDryCleaningControllerAdvice {
	
	/*******************
	 * Method                UserException
	 * Description           It is used to return the exception message and its HTTP status
	 * @response entity      It returns the exception message and its HTTP status. 
	 * @param exception      It is parent class of exception
	 * created by:           G. Anvesh
	 * created date:         25-MARCH-2021
	 *******************/
	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<String> handleRuntimeException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EmptyEntityListException.class })
	public ResponseEntity<String> handleEmptyEntityListException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityCreationException.class })
	public ResponseEntity<String> handleEntityCreationException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityDeletionException.class })
	public ResponseEntity<String> handleEntityDeletionException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityUpdationException.class })
	public ResponseEntity<String> handleEntityUpdationException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<String> handleEntityNotFoundException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

