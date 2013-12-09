package com.example.OperatorStack;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class OperatorNumber extends OperatorBase {
	
	private double value;
	
	public OperatorNumber(
			double d,
			TextRepInterface tr,
			int count) {
		super(FunctionType.NUMBER, tr, count);
		value = d;
	}

	@Override
	public double getResult(double[] dList) {
		return value;
	}

}
