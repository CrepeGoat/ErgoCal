package com.example.OperatorStack;

import java.util.ArrayList;

public class OperatorStack {

	private class OutputWrapper<Object> {
		public Object value;
		public int index;
		public OutputWrapper (Object o, int i) {
			value = o;
			index = i;
		}
	}
	
	private ArrayList<OperatorBase> argList = new ArrayList<OperatorBase>();
	
	public String getTextRep() {
		OutputWrapper<String> tmp = new OutputWrapper<String>(null,0);
		innerAssembleRep(tmp);
		return tmp.value;
	}
	public double getResult() {
		OutputWrapper<Double> tmp = new OutputWrapper<Double>(null,0);
		innerCalc(tmp);
		return tmp.value;
	}
	
	private void innerCalc(OutputWrapper<Double> box) {
		double[] vlist = new double[argList.get(box.index).getArgCount()];
		for (int i=0; i<vlist.length; ++i) {
			box.index += 1;
			innerCalc(box);
			vlist[i] = box.value;
		}
		box.value = argList.get(box.index).getResult(vlist);
	}
	private void innerAssembleRep(OutputWrapper<String> box) {
		String[] strList = new String[argList.get(box.index).getArgCount()];
		for (int i=0; i<strList.length; ++i) {
			box.index += 1;
			innerAssembleRep(box);
			strList[i] = box.value;
		}
		argList.get(box.index).setIdTag(box.index);
		box.value = argList.get(box.index).getTextRep(strList);		
	}

	//Navigation Methods
	public int getRoot(int index) {
		if (index == 0)
			return -1;
		int tmp=0;
		do {
			--index;
			tmp += 1-argList.get(index).getArgCount();
		} while (tmp > 0);
		return index;
	}
	//		Assumes index is not the rightmost node in level.
	public int getNextInLevel(int index) {
		int tmp=0;
		do {
			tmp += argList.get(index).getArgCount() - 1;
			++index;
		} while (tmp > 0 && index < argList.size());
		return index;
	}
	/*
	//		Assumes index is not the leftmost node of the level
	public int getPrevInLevel(int index) {
		//TODO
	}
	*/
}
