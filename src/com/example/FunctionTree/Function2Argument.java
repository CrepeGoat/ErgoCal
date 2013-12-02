package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function2Argument implements FunctionObjectInterface{
	private FunctionObjectInterface arg1, arg2;
	private Functor2Arg func;
	private TextRepInterface display;
	
	//Constructor
	public Function2Argument (TextRepInterface d,
			Functor2Arg f,
			FunctionObjectInterface a1,
			FunctionObjectInterface a2)
	{
		func = f;
		display = d;
		arg1 = a1;
		arg2 = a2;
	}
	
	public void setArg1(FunctionObjectInterface a1)
	{
		arg1 = a1;
	}
	public void setArg2(FunctionObjectInterface a2)
	{
		arg2 = a2;
	}
	public void setArgs(FunctionObjectInterface a1,
			FunctionObjectInterface a2)
	{
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
	
	public String getTextRep()
	{
		return display.getTextRep(arg1.getTextRep(), arg2.getTextRep());
	}
}
