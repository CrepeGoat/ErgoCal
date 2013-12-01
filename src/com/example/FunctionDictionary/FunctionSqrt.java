package com.example.FunctionDictionary;
import java.lang.Math;

public final class FunctionSqrt implements Functor1Arg {

	@Override
	public double calculate(double arg) {

		return Math.sqrt(arg);
	}

}
