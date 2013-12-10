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
	
	public OperatorBase make(FunctionType ftype) {
		switch (ftype) {
		case BLANK:
			return new OperatorBlank(trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case NUMBER:
			return new OperatorNumber(_number,
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case ADD:
			return new OperatorFunction(ftype,
					new FunctionAdd(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case MULTIPLY:
			return new OperatorFunction(ftype,
					new FunctionMultiply(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case SUBTRACT:
			return new OperatorFunction(ftype,
					new FunctionSubtract(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case DIVIDE:
			return new OperatorFunction(ftype,
					new FunctionDivide(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case POWER:
			return new OperatorFunction(ftype,
					new FunctionPower(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case SQUARE:
			return new OperatorFunction(ftype,
					new FunctionPower(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		case SQRT:
			return new OperatorFunction(ftype,
					new FunctionSqrt(),
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(ftype));
		default:
			return null;
		}
	}

	public OperatorBase makeDefaultArg(FunctionType ftype) {
		switch (ftype) {
		case SQUARE:
			return new OperatorNumber(2,
					trMaker.makeTextRep(ftype),
					FunctionType.defaultArgCount(FunctionType.NUMBER));
		default:
			return null;
		}
	}


}
