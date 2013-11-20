package com.example.FunctionTree;
import com.example.FunctionDictionary.BareFunction1Arg;

public final class Function1Argument implements FunctionObject {
	private BareFunction1Arg func;
	private FunctionObject arg;
	
	//Constructor
	public Function1Argument (BareFunction1Arg f, FunctionObject a)
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
}
