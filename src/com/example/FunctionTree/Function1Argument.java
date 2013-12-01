package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor1Arg;
import com.example.FunctionPresentation.Display1Arg;

public final class Function1Argument implements FunctionObject{
	private FunctionObject arg;
	private Functor1Arg func;
	private Display1Arg display;
	
	//Constructor
	public Function1Argument (Functor1Arg f, FunctionObject a)
	{
		func = f;
		arg = a;
	}
	
	public double calculate()
	{
		return func.calculate(arg.calculate());
	}
	
	public void clear()
	{
		arg.clear();
	}
	public int numberOfArguments()
	{
		return 1;
	}
	
	public String getDisplay()
	{
		return display.getDisplay(arg.getDisplay());
	}
}
