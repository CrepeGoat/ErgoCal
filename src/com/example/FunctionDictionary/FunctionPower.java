package com.example.FunctionDictionary;
import java.lang.Math;

public final class FunctionPower implements Functor2Arg {

	@Override
	public double calculate(double arg1, double arg2) {

		return Math.pow(arg1, arg2);
	}

}
