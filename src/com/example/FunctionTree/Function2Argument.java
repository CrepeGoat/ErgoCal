package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function2Argument extends FunctionObjectBase{
	private FunctionObjectBase arg1, arg2;
	private Functor2Arg func;
	
	//Constructor
	public Function2Argument (FunctionID i,
			TextRepInterface d,
			Functor2Arg f,
			FunctionObjectBase a1,
			FunctionObjectBase a2)
	{
		super(i,d);
		func = f;
		display = d;
		arg1 = a1;
		arg2 = a2;
	}
	
	public void setArg1(FunctionObjectBase a1)
	{
		arg1 = a1;
	}
	public void setArg2(FunctionObjectBase a2)
	{
		arg2 = a2;
	}
	public void setArgs(FunctionObjectBase a1,
			FunctionObjectBase a2)
	{
		arg1 = a1;
		arg2 = a2;
	}
	
	//Interface functions
	public double calculate()
	{
		return func.calculate(arg1.calculate(), arg2.calculate());
	}
	
	public void close()
	{
		super.close();
		if (arg1 != null)
			arg1.close();
		if (arg2 != null)
			arg2.close();
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
