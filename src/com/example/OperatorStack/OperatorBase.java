package com.example.OperatorStack;

import com.example.FunctionExtras.*;
import com.example.FunctionPresentation.TextRepInterface;

abstract class OperatorBase {
	
	abstract public double getResult(double[] dList) throws CalculationException;

	private FunctionType ftype;
	private TextRepInterface display;
	private int argCount;
	
	public OperatorBase(FunctionType ft,
			TextRepInterface tr,
			int count) {
		ftype = ft;
		display = tr;
		argCount = count;
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
	
	public String getTextRep(String[] strList) {
		return display.getTextRep(strList);
	}
	public void setIdTag(int i) {
		display.setIdTag(i);
	}

}
