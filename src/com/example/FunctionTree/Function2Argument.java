package com.example.FunctionTree;
import com.example.FunctionDictionary.BareFunction2Arg;

public final class Function2Argument {
	private BareFunction2Arg func;
	private FunctionObject arg1, arg2;
	
	//Constructor
	public Function2Argument (BareFunction2Arg f, FunctionObject a1, FunctionObject a2)
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
}
