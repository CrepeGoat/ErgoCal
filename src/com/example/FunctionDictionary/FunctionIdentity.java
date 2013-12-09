package com.example.FunctionDictionary;

public class FunctionIdentity implements Functor1Arg, FunctionInterface {

	@Override
	public double calculate(double arg) {
		return arg;
	}
	
	public double calculate(double[] dlist) {
		return dlist[0];
	}

}
