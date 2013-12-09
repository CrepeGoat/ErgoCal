package com.example.FunctionDictionary;

public class FunctionAdd implements Functor2Arg, FunctionInterface {

	@Override
	public double calculate(double arg1, double arg2) {
		return arg1 + arg2;
	}
	
	public double calculate(double[] dlist) {
		double sum = 0;
		for (double e : dlist)
			sum += e;
		return sum;
	}

}
