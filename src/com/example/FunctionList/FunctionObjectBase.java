package com.example.FunctionList;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public abstract class FunctionObjectBase {

	protected TextRepInterface display;
	protected FunctionType ftype;
	
	protected FunctionObjectBase(
			TextRepInterface d,
			FunctionType fid)
	{
		display = d;
		ftype = fid;
	}
	
	public FunctionType getFID() {
		return ftype;
	}
	
	public String getDisplay(String[] slist){
		return display.getTextRep(slist);
	}
	
	abstract public int getNumOfArgs();
	abstract public double calculate(double[] vlist);
}
