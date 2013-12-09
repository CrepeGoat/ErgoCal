package com.example.FunctionExtras;

public final class CalculationException extends Exception {
	private Object cause;
	
	public CalculationException(
			String message, 
			Object c) {
		super(message);
		cause = c;
	}
	
	public Object getCauseObject()
	{
		return cause;
	}
}
