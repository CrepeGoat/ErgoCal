package com.example.FunctionDictionary;
import java.lang.Math;

public class FunctionSqrt implements Functor1Arg, FunctionInterface {

	@Override
	public double calculate(double arg) {

		return Math.sqrt(arg);
	}

	public double calculate(double[] dlist) {

		return Math.sqrt(dlist[0]);
	}

}
