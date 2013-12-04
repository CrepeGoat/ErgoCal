package com.example.FunctionList;

import com.example.FunctionDictionary.Functor2Arg;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;

public class FuncObjMultiArg extends FunctionObjectBase {

	private Functor2Arg func;
	private int length;
	
	public FuncObjMultiArg (TextRepInterface d,
			FunctionType fid,
			Functor2Arg f)
	{
		super(d,fid);
		func = f;
	}
	@Override
	public int getNumOfArgs() {
		return length;
	}

	@Override
	public double calculate(double[] vlist) {
		double tmp = func.calculate(vlist[0], vlist[1]);
		for(int i=2; i<vlist.length; ++i)
			tmp = func.calculate(tmp, vlist[i]);
		return tmp;
	}

}
