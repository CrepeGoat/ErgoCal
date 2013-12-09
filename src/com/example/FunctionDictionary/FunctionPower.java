package com.example.FunctionDictionary;
import java.lang.Math;

public class FunctionPower implements Functor2Arg, FunctionInterface {

	@Override
	public double calculate(double arg1, double arg2) {

		return Math.pow(arg1, arg2);
	}

	public double calculate(double[] dlist) {
		return Math.pow(dlist[0], dlist[1]);
	}

}
