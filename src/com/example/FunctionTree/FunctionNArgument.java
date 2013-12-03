package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionPresentation.TextRepInterface;
import java.util.ArrayList;

public class FunctionNArgument extends FunctionObjectBase {

	private Functor2Arg func;
	private ArrayList<FunctionObjectBase> argList;
	private void setArg(int n, FunctionObjectBase a)
	{
		if (0 <= n && n < argList.size())
		{
			argList.set(n, a);
			if (a != null)
				a.root = this;
		}
	}
	
	public FunctionNArgument(FunctionID i,
			TextRepInterface d,
			Functor2Arg f,
			ArrayList<FunctionObjectBase> l)
	{
		super(i,d);
		func = f;
		argList = l;
		for (int j=0; j<l.size(); ++j)
			if (l.get(j) != null)
				l.get(j).root = this;
	}
	
	public void addArg(FunctionObjectBase a)
	{
		if (argList.get(0).getFID() == FunctionID.BLANK)
			setArg(0, a);
		else if (argList.get(1).getFID() == FunctionID.BLANK)
			setArg(1, a);
		else
		{
			argList.add(a);
			if (a != null)
				a.root = this;
		}
	}
	
	public void addArgReverse(FunctionObjectBase a)
	{
		if (argList.get(1).getFID() == FunctionID.BLANK)
			setArg(1, a);
		else if (argList.get(0).getFID() == FunctionID.BLANK)
			setArg(0, a);
		else
		{
			argList.add(0, a);
			if (a != null)
				a.root = this;
		}
	}
	
	public void resetArg(FunctionObjectBase old, FunctionObjectBase a)
	{
		for (int i=0; i<argList.size(); ++i)
			if (argList.get(i) == old)
			{
				setArg(i, a);
				break;
			}
		
		throw new RuntimeException("Argument not found");
	}
	
	public boolean removeArg(FunctionObjectBase a)
	{
		for (int i=0; i<argList.size(); ++i)
			if (argList.get(i) == a)
			{
				argList.remove(i);
				return false;
			}
		return true;
	}
	
	@Override
	public double calculate() throws CalculationException
	{
		double temp = func.calculate(
				argList.get(0).calculate(), 
				argList.get(1).calculate());
		//Note - assumes that there are AT LEAST 2 arguments in list
		for (int i=2; i<argList.size(); ++i)
			temp = func.calculate(temp, argList.get(i).calculate());
		
		return temp;
	}

	@Override
	public void close()
	{
		super.close();
		for (int i=0; i<argList.size(); ++i)
			if (argList.get(i) != null)
				argList.get(i).close();
	}

	@Override
	public int numberOfArguments() {
		return argList.size();
	}

	@Override
	public String getTextRep() {
		String[] temp = new String[argList.size()];
		for (int i=0; i<temp.length; ++i)
			temp[i] = argList.get(i).getTextRep();
		
		return display.getTextRep(temp);
	}

}
