package com.example.FunctionList;

import java.util.ArrayList;

public class FunctionWrapper {

	private class ValueWrapper {
		public double value;
		public int index;
	};
	
	private class TextWrapper {
		public String text;
		public int index;
	}
	
	private ArrayList<FunctionObjectBase> argList;
	
	public int getNumOfObjs()
	{
		return argList.size();
	}
	
	private ValueWrapper innerCalc(int index)
	{
		ValueWrapper tmp = new ValueWrapper();
		tmp.index = index;
		double[] vlist = new double[argList.get(index).getNumOfArgs()];
		for (int i=0; i<vlist.length; ++i) {
			tmp = innerCalc(tmp.index+1);
			vlist[i] = tmp.value;
		}
		tmp.value = argList.get(index).calculate(vlist);
		
		return tmp;
	}
	public double calculate(){
		return innerCalc(0).value;
	}
}
