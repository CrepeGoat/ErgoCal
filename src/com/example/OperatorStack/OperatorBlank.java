package com.example.OperatorStack;

import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class OperatorBlank extends OperatorBase {

	public OperatorBlank(
			TextRepInterface... tr) {
		super(FunctionType.BLANK,tr);
	}
	
	@Override
	public double getResult(double[] dList) throws CalculationException {
		throw new CalculationException("Undefined function object", this);
	}
	
	public String getTextRep(String... strList) {
		return display[0].getTextRep(displayFlags, strList);
	}


}
