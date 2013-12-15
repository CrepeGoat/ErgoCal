package com.example.OperatorStack;

import com.example.FunctionExtras.*;
import com.example.FunctionPresentation.TextRepInterface;

abstract class OperatorBase {
	
	abstract public double getResult(double[] dList) throws CalculationException;
	abstract public String getTextRep(String... strList);

	private FunctionType ftype;
	protected TextRepInterface[] display;
	protected int displayFlags=0;
	private int argCount;
	
	public OperatorBase(FunctionType ft,
			TextRepInterface... tr) {
		ftype = ft;
		display = tr;
		argCount = FunctionType.defaultArgCount(ft);
	}
	
	public int getArgCount() {
		return argCount;
	}
	public void incrementArgCount() {
		++argCount;
	}
	public void decrementArgCount() {
		--argCount;
	}
	
	public FunctionType getFuncType() {
		return ftype;
	}
	
	public void setIdTag(int tag) {
		for (int i=0; i<display.length; ++i) {
			display[i].setIdTag(tag);
		}
	}
	
	public void setActiveDisplayFlags(int flags) {
		displayFlags = displayFlags | flags;
	}

	public void setInactiveDisplayFlags(int flags) {
		displayFlags = displayFlags & (~flags);
	}

}
