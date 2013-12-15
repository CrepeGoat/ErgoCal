package com.example.OperatorStack;

import com.example.FunctionDictionary.*;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class OperatorFunction extends OperatorBase {

	private FunctionInterface func;
	
	public OperatorFunction(FunctionType ft,
			FunctionInterface f,
			TextRepInterface... tr) {
		super(ft, tr);
		func = f;
	}
	
	@Override
	public double getResult(double[] dList) {
		return func.calculate(dList);
	}
	
	public String getTextRep(String... strList) {
		if (display.length == 2)
			if ((displayFlags & TextRepInterface.EXPAND_EXP) == 0)
				return display[0].getTextRep(displayFlags, strList);
			else
				return display[1].getTextRep(displayFlags, strList);
		else if (display.length == 1)
			return display[0].getTextRep(displayFlags, strList);
		else
			throw new RuntimeException("Invalid TextRep construction");
	}

}
