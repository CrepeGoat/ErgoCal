package com.example.OperatorStack;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.*;
import com.example.FunctionDictionary.*;

public class OperatorBuilder {
	
	private TextRepMakerInterface trMaker;
	private double _number;
	
	public OperatorBuilder(TextRepMakerInterface t) {
		trMaker = t;
	}
	
	public OperatorBuilder number(double d) {
		_number = d;
		return this;
	}
	
	public OperatorBase makeOperator(FunctionType ftype) {
		switch (ftype) {
		case BLANK:
			return new OperatorBlank(trMaker.makeTextRep(ftype));
		case NUMBER:
			return new OperatorNumber(_number,
					trMaker.makeTextRep(ftype));
		case ADD:
			return new OperatorFunction(ftype,
					new FunctionAdd(),
					trMaker.makeTextRep(ftype));
		case MULTIPLY:
			return new OperatorFunction(ftype,
					new FunctionMultiply(),
					trMaker.makeTextRep(ftype));
		case SUBTRACT:
			return new OperatorFunction(ftype,
					new FunctionSubtract(),
					trMaker.makeTextRep(ftype));
		case DIVIDE:
			return new OperatorFunction(ftype,
					new FunctionDivide(),
					trMaker.makeTextRep(ftype));
		case POWER:
			return new OperatorFunction(ftype,
					new FunctionPower(),
					trMaker.makeTextRep(ftype));
		case SQUARE:
			return new OperatorFunction(ftype,
					new FunctionPower(),
					trMaker.makeTextRep(ftype));
		case SQRT:
			return new OperatorFunction(ftype,
					new FunctionSqrt(),
					trMaker.makeTextRep(ftype));
		default:
			return null;
		}
	}

	public OperatorBase makeDefaultArg(FunctionType ftype) {
		switch (ftype) {
		case SQUARE:
			return new OperatorNumber(2,
					trMaker.makeTextRep(FunctionType.NUMBER));
		default:
			return null;
		}
	}


}
