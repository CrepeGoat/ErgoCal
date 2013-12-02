package com.example.FunctionTree;
import com.example.FunctionPresentation.TextRepInterface;

public final class FunctionNumber implements FunctionObjectInterface{
	// Internal value holder
	private double value;
	private TextRepInterface display;
	
	// Constructor
	public FunctionNumber(TextRepInterface d, double v)
	{
		value = v;
		display = d;
	}
	
	// FunctionObjectInterface Methods
	public double calculate()
	{
		return value;
	}
	
	public void clear() {}
	
	public int numberOfArguments()
	{
		return 0;
	}
	
	public String getTextRep()
	{
		return display.getTextRep(String.valueOf(value));
	}
	
	// Other Methods
	public void set(double v)
	{
		value = v;
	}
}
