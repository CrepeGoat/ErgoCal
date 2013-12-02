package com.example.FunctionTree;
import java.util.ArrayList;
import com.example.FunctionDictionary.*;
import com.example.FunctionPresentation.*;

public class FunctionObjectMaker {
	
	TextRepMakerInterface trmaker;
	ArrayList<FunctionObjectInterface> argList;
	double _number = 0;
	
	public FunctionObjectMaker(TextRepMakerInterface trm)
	{
		trmaker = trm;
		argList.add(null);
		argList.add(null);
	}
	
	public FunctionObjectMaker arg(FunctionObjectInterface a)
	{
		if (argList.get(0) == null)
			argList.set(0, a);
		else if (argList.get(1) == null)
			argList.set(1, a);
		else
			argList.add(a);
		return this;
	}
	public FunctionObjectMaker arg2(FunctionObjectInterface a)
	{
		if (argList.get(1) == null)
			argList.set(1, a);
		else if (argList.get(0) == null)
			argList.set(0, a);
		else
			argList.add(a);
		return this;
	}
	public FunctionObjectMaker number(double n)
	{
		_number = n;
		return this;
	}
	
	public FunctionObjectInterface make(FunctionID id)
	{
		FunctionObjectInterface obj;
		switch (id)
		{
		case NUMBER:
			obj = new FunctionNumber(trmaker.makeTextRep(id), 0);
			break;
		case ADD:
			obj = new FunctionNArgument(trmaker.makeTextRep(id),
					new FunctionAdd(),
					argList);
			break;
		case MULTIPLY:
			obj = new FunctionNArgument(trmaker.makeTextRep(id),
					new FunctionMultiply(),
					argList);
			break;
		case SUBTRACT:
			obj = new Function2Argument(trmaker.makeTextRep(id),
					new FunctionSubtract(),
					argList.get(0), argList.get(1));
			break;
		case DIVIDE:
			obj = new Function2Argument(trmaker.makeTextRep(id),
					new FunctionDivide(),
					argList.get(0), argList.get(1));
			break;
		case POWER:
			obj = new Function2Argument(trmaker.makeTextRep(id),
					new FunctionPower(),
					argList.get(0), argList.get(1));
			break;
		case SQUARE:
			obj = new Function2Argument(trmaker.makeTextRep(id),
					new FunctionPower(),
					argList.get(0),
					new FunctionNumber(trmaker.makeTextRep(FunctionID.NUMBER),2.0));
			break;
		case SQRT:
			obj = new Function1Argument(trmaker.makeTextRep(id),
					new FunctionSqrt(),
					argList.get(0));
			break;
		default:
			obj = null;
			break;
		}
		
		return obj;
	}

}
