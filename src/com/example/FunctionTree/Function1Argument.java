package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor1Arg;
import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function1Argument extends FunctionObjectBase{
	private FunctionObjectBase arg;
	private Functor1Arg func;
	private void setArg(FunctionObjectBase a)
	{
		arg = a;
		if (arg != null)
			arg.root = this;
	}
	
	//Constructor
	public Function1Argument (FunctionType i,
			TextRepInterface d,
			Functor1Arg f,
			FunctionObjectBase a)
	{
		super(i,d);
		func = f;
		display = d;
		setArg(a);
	}
	
	public void replaceArg(FunctionObjectBase old, FunctionObjectBase a)
	{
		if (arg == old)
			setArg(a);
		else
			throw new RuntimeException("No Arguments to Replace");
	}
	
	public double calculate() throws CalculationException
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
	
	public void setHighlight()
	{
		display.setHighlight();
		arg.setSubHighlight();
	}
	public void setSubHighlight()
	{
		display.setSubHighlight();
		arg.setSubHighlight();
	}
	public void setNoHighlight()
	{
		display.setNoHighlight();
		arg.setNoHighlight();
	}
}
