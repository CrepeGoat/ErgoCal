package com.example.FunctionDictionary;

/*
 * The Functor interface for functions of 2-arguments. Used in place
 * of function pointers.
 */
public interface Functor2Arg {
	public double calculate(double arg1, double arg2);
}
