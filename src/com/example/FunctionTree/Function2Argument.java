package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionPresentation.Display2Arg;

public final class Function2Argument {
	private FunctionObject arg1, arg2;
	private Functor2Arg func;
	private Display2Arg display;
	
	//Constructor
	public Function2Argument (Functor2Arg f, FunctionObject a1, FunctionObject a2)
	{
		func = f;
		arg1 = a1;
		arg2 = a2;
	}
	
	//Interface functions
	public double calculate()
	{
		return func.calculate(arg1.calculate(), arg2.calculate());
	}
	
	public void clear()
	{
		arg1.clear();
		arg2.clear();
	}
	public int numberOfArguments()
	{
		return 2;
	}
	
	public String getDisplay()
	{
		return display.getDisplay(arg1.getDisplay(), arg2.getDisplay());
	}
}
