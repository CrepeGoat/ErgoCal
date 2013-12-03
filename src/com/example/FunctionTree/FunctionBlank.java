package com.example.FunctionTree;

import com.example.FunctionPresentation.TextRepInterface;

public final class FunctionBlank extends FunctionObjectBase {

	public FunctionBlank(TextRepInterface d)
	{
		super(FunctionID.BLANK,d);
	}
	
	public void resetArg(FunctionObjectBase old, FunctionObjectBase a)
	{
		throw new RuntimeException("No Arguments to Replace");
	}
	
	@Override
	public double calculate() throws CalculationException {
		throw new CalculationException("Undefined function object", this);
	}

	
	@Override
	public void close()
	{
		super.close();
	}

	@Override
	public int numberOfArguments() {
		return 0;
	}

	@Override
	public String getTextRep() {
		return display.getTextRep();
	}

}
