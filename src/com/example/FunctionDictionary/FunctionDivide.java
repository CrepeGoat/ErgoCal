package com.example.FunctionDictionary;

public class FunctionDivide implements Functor2Arg, FunctionInterface {

	@Override
	public double calculate(double arg1, double arg2) {

		return arg1/arg2;
	}
	
	public double calculate(double[] dlist) {
		return dlist[0]/dlist[1];
	}

}
