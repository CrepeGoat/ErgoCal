package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor1Arg;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function1Argument extends FunctionObjectBase{
	private FunctionObjectBase arg;
	private Functor1Arg func;
	
	//Constructor
	public Function1Argument (FunctionID i,
			TextRepInterface d,
			Functor1Arg f,
			FunctionObjectBase a)
	{
		super(i,d);
		func = f;
		display = d;
		arg = a;
	}
	
	public void setArg(FunctionObjectBase a)
	{
		arg = a;
	}
	
	public double calculate()
	{
		return func.calculate(arg.calculate());
	}
	
	public void close()
	{
		super.close();
		if (arg != null)
			arg.close();
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
