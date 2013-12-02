package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor1Arg;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function1Argument implements FunctionObjectInterface{
	private FunctionObjectInterface arg;
	private Functor1Arg func;
	private TextRepInterface display;
	
	//Constructor
	public Function1Argument (TextRepInterface d,
			Functor1Arg f,
			FunctionObjectInterface a)
	{
		func = f;
		display = d;
		arg = a;
	}
	
	public void setArg(FunctionObjectInterface a)
	{
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
	
	public String getTextRep()
	{
		return display.getTextRep(arg.getTextRep());
	}
}
