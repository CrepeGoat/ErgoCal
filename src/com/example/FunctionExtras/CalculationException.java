package com.example.FunctionExtras;

import com.example.FunctionTree.FunctionObjectBase;

public final class CalculationException extends Exception {
	private FunctionObjectBase cause;
	
	public CalculationException(
			String message, 
			FunctionObjectBase c)
	{
		super(message);
		cause = c;
	}
	
	public FunctionObjectBase getCauseObject()
	{
		return cause;
	}

}
