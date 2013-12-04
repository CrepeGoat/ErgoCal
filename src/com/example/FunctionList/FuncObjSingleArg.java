package com.example.FunctionList;

import com.example.FunctionExtras.*;
import com.example.FunctionPresentation.TextRepInterface;
import com.example.FunctionDictionary.Functor1Arg;

public class FuncObjSingleArg extends FunctionObjectBase {

	private Functor1Arg func;
	
	public FuncObjSingleArg (TextRepInterface d,
			FunctionType fid,
			Functor1Arg f)
	{
		super(d,fid);
		func = f;
	}
	
	@Override
	public int getNumOfArgs() {
		return 1;
	}

	@Override
	public double calculate(double[] vlist) {
		return func.calculate(vlist[0]);
	}

}
