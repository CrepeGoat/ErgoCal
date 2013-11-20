package com.example.FunctionTree;

/*
 * The interface for the function-object components which, when nested,
 * can imitate any compiled mathematical function.
 */
public interface FunctionObject {
	public double calculate();
	public void clear();
	public int numberOfArguments();
}
