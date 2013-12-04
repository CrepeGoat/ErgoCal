package com.example.FunctionTree;
import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public final class Function2Argument extends FunctionObjectBase{
	private FunctionObjectBase arg1, arg2;
	private Functor2Arg func;
	private void setArg1(FunctionObjectBase a1)
	{
		arg1 = a1;
		if (arg1 != null)
			arg1.root = this;
	}
	private void setArg2(FunctionObjectBase a2)
	{
		arg2 = a2;
		if (arg2 != null)
			arg2.root = this;
	}
	
	//Constructor
	public Function2Argument (FunctionType i,
			TextRepInterface d,
			Functor2Arg f,
			FunctionObjectBase a1,
			FunctionObjectBase a2)
	{
		super(i,d);
		func = f;
		display = d;
		setArg1(a1);
		setArg2(a2);
	}
	
	public void replaceArg(FunctionObjectBase old, FunctionObjectBase a)
	{
		if (arg1 == old)
			setArg1(a);
		else if (arg2 == old)
			setArg2(a);
		else
			throw new RuntimeException("Argument not found");
	}

	
	
	//Interface functions
	public double calculate() throws CalculationException
	{
		return func.calculate(arg1.calculate(), arg2.calculate());
	}
	
	public void close()
	{
		super.close();
		if (arg1 != null)
			arg1.close();
		if (arg2 != null)
			arg2.close();
	}
	public int numberOfArguments()
	{
		return 2;
	}
	
	public String getTextRep()
	{
		return display.getTextRep(arg1.getTextRep(), arg2.getTextRep());
	}
	public void setHighlight() {
		display.setHighlight();
		arg1.setSubHighlight();
		arg2.setSubHighlight();
	}
	public void setSubHighlight() {
		display.setSubHighlight();
		arg1.setSubHighlight();
		arg2.setSubHighlight();
	}
	public void setNoHighlight() {
		display.setNoHighlight();
		arg1.setNoHighlight();
		arg2.setNoHighlight();
	}
}
