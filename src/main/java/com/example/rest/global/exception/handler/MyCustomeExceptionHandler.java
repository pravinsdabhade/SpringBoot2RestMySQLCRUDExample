package com.example.rest.global.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.rest.custom.exception.EmployeeNotFoundExcetion;
import com.example.rest.error.ErrorType;

@RestControllerAdvice
public class MyCustomeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundExcetion.class)
	public ResponseEntity<ErrorType> handelEmployeeNotFoundException(EmployeeNotFoundExcetion enfe){
		return new ResponseEntity<>(new ErrorType(new Date().toString(),
												"EMPLOYEE",
												enfe.getMessage(),
												"Processing issue"),
												HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
