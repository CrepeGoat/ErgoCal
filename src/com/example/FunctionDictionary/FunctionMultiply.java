package com.example.FunctionDictionary;

public class FunctionMultiply implements Functor2Arg, FunctionInterface {

	@Override
	public double calculate(double arg1, double arg2) {

		return arg1*arg2;
	}

	public double calculate(double[] dlist) {
		double product = 1;
		for (double e : dlist)
			product *= e;
		return product;
	}

}
