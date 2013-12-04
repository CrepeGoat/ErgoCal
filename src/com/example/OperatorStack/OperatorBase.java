package com.example.OperatorStack;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionList.FunctionInterface;
import com.example.FunctionPresentation.TextRepInterface;


class OperatorBase {
	
	private FunctionType ftype;
	private TextRepInterface display;
	private FunctionInterface func;
	private int count;
	
	public int getArgCount() {
		return count;
	}
	public void incrementArgCount() {
		++count;
	}
	public void decrementArgCount()
	{
		--count;
	}
	
	public double getResult(double[] dList) {
		return func.calculate(dList);
	}
	public String getTextRep(String[] strList) {
		return display.getTextRep(strList);
	}
	public void setIdTag(int i) {
		//TODO
	}

}
