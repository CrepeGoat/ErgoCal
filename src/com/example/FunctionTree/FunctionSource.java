package com.example.FunctionTree;

import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public final class FunctionSource
extends FunctionObjectBase {
	private FunctionObjectBase arg;

	public FunctionSource(
			TextRepInterface d,
			FunctionObjectBase f)
	{
		super(FunctionType.SOURCE, d);
		arg = f;
	}
	
	public FunctionObjectBase getArg()
	{
		return arg;
	}
	
	public void replaceArg(FunctionObjectBase old, FunctionObjectBase a)
	{
		if (arg == old)
			arg = a;
		else
			throw new RuntimeException("No Arguments to Replace");
	}
	
	public double calculate() throws CalculationException
	{
		return arg.calculate();
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
	
	public void setHighlight() {}
	public void setSubHighlight() {}
	public void setNoHighlight() {}


}
