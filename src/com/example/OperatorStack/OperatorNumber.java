package com.example.OperatorStack;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class OperatorNumber extends OperatorBase {
	
	private double value;
	
	public OperatorNumber(
			double d,
			TextRepInterface... tr) {
		super(FunctionType.NUMBER, tr);
		value = d;
	}
	
	@Override
	public double getResult(double[] dList) {
		return value;
	}
	
	public String getTextRep(String... strList) {
		return display[0].getTextRep(displayFlags, value, strList);
	}
	
	public void setValue(double d) {
		value = d;
	}

}
