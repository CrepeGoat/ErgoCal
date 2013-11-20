package com.example.FunctionTree;

public final class FunctionNumber implements FunctionObject{
	// Internal value holder
	private double value;
	
	// Constructor
	public FunctionNumber(double v)
	{
		value = v;
	}
	
	// FunctionObject Methods
	public double calculate()
	{
		return value;
	}
	
	public void clear() {}
	
	public int numberOfArguments()
	{
		return 0;
	}
	
	// Other Methods
	public void set(double v)
	{
		value = v;
	}
}
