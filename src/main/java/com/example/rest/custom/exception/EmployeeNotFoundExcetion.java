package com.example.rest.custom.exception;

public class EmployeeNotFoundExcetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundExcetion() {
		super();
	}
	
	public EmployeeNotFoundExcetion(String message) {
		super(message);
	}

}
