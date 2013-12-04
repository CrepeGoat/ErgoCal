package com.example.FunctionList;

import com.example.FunctionExtras.*;
import com.example.FunctionPresentation.TextRepInterface;

public final class FuncObjNumber extends FunctionObjectBase {

	private double value;
	
	public FuncObjNumber(TextRepInterface d, double v) {
		super(d,FunctionType.NUMBER);
		value = v;
	}
	
	@Override
	public int getNumOfArgs() {
		return 0;
	}

	@Override
	public double calculate(double[] list) {
		return value;
	}

}
