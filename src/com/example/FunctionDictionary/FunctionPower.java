package com.example.FunctionDictionary;
import java.lang.Math;

public final class FunctionPower implements BareFunction2Arg {

	@Override
	public double calculate(double arg1, double arg2) {

		return Math.pow(arg1, arg2);
	}

}
