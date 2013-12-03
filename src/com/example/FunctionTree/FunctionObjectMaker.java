package com.example.FunctionTree;
import java.util.ArrayList;
import com.example.FunctionDictionary.*;
import com.example.FunctionPresentation.*;

public class FunctionObjectMaker {
	
	TextRepMakerInterface trmaker;
	ArrayList<FunctionObjectBase> argList;
	double _number = 0;
	
	public FunctionObjectMaker(TextRepMakerInterface trm)
	{
		trmaker = trm;
		argList.add(null);
		argList.add(null);
	}
	
	public FunctionObjectMaker arg(FunctionObjectBase a)
	{
		if (argList.get(0) == null)
			argList.set(0, a);
		else if (argList.get(1) == null)
			argList.set(1, a);
		else
			argList.add(a);
		return this;
	}
	public FunctionObjectMaker arg2(FunctionObjectBase a)
	{
		if (argList.get(1) == null)
			argList.set(1, a);
		else if (argList.get(0) == null)
			argList.set(0, a);
		else
			argList.add(0, a);
		return this;
	}
	public FunctionObjectMaker number(double n)
	{
		_number = n;
		return this;
	}
	
	public FunctionObjectBase make(FunctionID id)
	{
		for (int i=0; i<argList.size(); ++i)
			if (argList.get(i) == null)
				argList.set(i, new FunctionBlank(
						trmaker.makeTextRep(FunctionID.BLANK)));
		switch (id)
		{
		case BLANK:
			return new FunctionBlank(trmaker.makeTextRep(id));
		case SOURCE:
			return new Function1Argument(id,
					trmaker.makeTextRep(id),
					new FunctionIdentity(),
					argList.get(0));
		case NUMBER:
			return new FunctionNumber(trmaker.makeTextRep(id), _number);
		case ADD:
			return new FunctionNArgument(id,
					trmaker.makeTextRep(id),
					new FunctionAdd(),
					argList);
		case MULTIPLY:
			return new FunctionNArgument(id,
					trmaker.makeTextRep(id),
					new FunctionMultiply(),
					argList);
		case SUBTRACT:
			return new Function2Argument(id,
					trmaker.makeTextRep(id),
					new FunctionSubtract(),
					argList.get(0), argList.get(1));
		case DIVIDE:
			return new Function2Argument(id,
					trmaker.makeTextRep(id),
					new FunctionDivide(),
					argList.get(0), argList.get(1));
		case POWER:
			return new Function2Argument(id,
					trmaker.makeTextRep(id),
					new FunctionPower(),
					argList.get(0), argList.get(1));
		case SQUARE:
			return new Function2Argument(id,
					trmaker.makeTextRep(id),
					new FunctionPower(),
					argList.get(0),
					new FunctionNumber(trmaker.makeTextRep(FunctionID.NUMBER),2.0));
		case SQRT:
			return new Function1Argument(id,
					trmaker.makeTextRep(id),
					new FunctionSqrt(),
					argList.get(0));
		default:
			return null;
		}
	}
}
