package com.example.FunctionTree;

import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public final class FunctionBlank extends FunctionObjectBase {

	public FunctionBlank(TextRepInterface d)
	{
		super(FunctionType.BLANK,d);
	}
	
	public void replaceArg(FunctionObjectBase old, FunctionObjectBase a)
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
	
	public void setHighlight() {
		display.setHighlight();
	}
	public void setSubHighlight() {
		display.setSubHighlight();
	}
	public void setNoHighlight() {
		display.setNoHighlight();
	}

}
