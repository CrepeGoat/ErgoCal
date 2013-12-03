package com.example.FunctionTree;

import com.example.FunctionPresentation.TextRepInterface;

/*
 * The interface for the function-object components which, when nested,
 * can imitate any compiled mathematical function.
 */
public abstract class FunctionObjectBase {
	protected TextRepInterface display;
	protected FunctionID id;
	
	public FunctionObjectBase(FunctionID i, TextRepInterface d)
	{
		display = d;
		id = i;
	}
	
	abstract public double calculate();
	abstract public void clear();
	abstract public int numberOfArguments();
	
	abstract public String getTextRep();
}
