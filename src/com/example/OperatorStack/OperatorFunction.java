package com.example.OperatorStack;

import com.example.FunctionDictionary.*;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class OperatorFunction extends OperatorBase {

	private FunctionInterface func;
	
	public OperatorFunction(FunctionType ft,
			FunctionInterface f,
			TextRepInterface tr,
			int count) {
		super(ft, tr, count);
		func = f;
	}
	
	@Override
	public double getResult(double[] dList) {
		return func.calculate(dList);
	}

}
