package com.example.FunctionTree;
import com.example.FunctionPresentation.DisplayNum;

public final class FunctionNumber implements FunctionObject{
	// Internal value holder
	private double value;
	private DisplayNum display;
	
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
	
	public String getDisplay()
	{
		return display.getDisplay(String.valueOf(value));
	}
	
	// Other Methods
	public void set(double v)
	{
		value = v;
	}
}
