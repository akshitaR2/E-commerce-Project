package com.project.orderService.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.orderService.exception.CustomerNotFoundException;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handle(EntityNotFoundException exp) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
		var errors = new HashMap<String, String>();
		exp.getBindingResult().getAllErrors().forEach(error -> {
			var fieldName = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return ResponseEntity.status(BAD_REQUEST).body(new ErrorResponse(errors));
	}

	  @ExceptionHandler(CustomerNotFoundException.class)
	  public ResponseEntity<String> handle(CustomerNotFoundException exp) {
	    return ResponseEntity
	        .status(HttpStatus.BAD_REQUEST)
	        .body(exp.getMsg());
	  }
}