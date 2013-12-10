package com.example.FunctionExtras;

public class AssignmentException extends Exception {

	static final long serialVersionUID = 0;
	private String message;
	public AssignmentException(String string) {
		message = string;
	}
	
	public String getMessage() {
		return message;
	}

}
