package com.learning.employeedirectory.errorHandling;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException() {
		
	}
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
