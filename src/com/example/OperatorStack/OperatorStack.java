package com.example.OperatorStack;

import java.util.ArrayList;
import com.example.FunctionPresentation.*;
import com.example.FunctionExtras.*;

public class OperatorStack {

	private class OutputWrapper<T> {
		public T value;
		public int index;
		public OutputWrapper (T t, int i) {
			value = t;
			index = i;
		}
	}
	
	private ArrayList<OperatorBase> argList;
	private OperatorBuilder opMaker;
	
	// Constructor
	public OperatorStack(TextRepMakerInterface trm) {
		opMaker = new OperatorBuilder(trm);
		argList = new ArrayList<OperatorBase>();
		argList.add(opMaker.make(FunctionType.BLANK));
	}
	
	//--------------------------------------------------------------------
	//Indexed Get Methods
	public FunctionType getFuncType(int index) {
		if (index == -1) return FunctionType.SOURCE;
		return argList.get(index).getFuncType();
	}
	
	//--------------------------------------------------------------------
	//Return Methods
	public double getResult() throws CalculationException {
		OutputWrapper<Double> tmp = new OutputWrapper<Double>(null,0);
		innerCalc(tmp);
		return tmp.value;
	}
	
	private void innerCalc(OutputWrapper<Double> box) throws CalculationException {
		double[] vlist = new double[argList.get(box.index).getArgCount()];
		for (int i=0; i<vlist.length; ++i) {
			box.index += 1;
			innerCalc(box);
			vlist[i] = box.value;
		}
		try {
			box.value = argList.get(box.index).getResult(vlist);
		} catch (CalculationException e) {
			((OperatorBase)e.getCauseObject()).setIdTag(box.index);
			throw e;
		}
	}

	public String getTextRep() {
		OutputWrapper<String> tmp = new OutputWrapper<String>(null,0);
		innerAssembleRep(tmp);
		return tmp.value;
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

	//--------------------------------------------------------------------
	//Navigation Methods
	private int getRoot(int index) {
		if (index == 0)
			return -1;
		int tmp=0;
		do {
			--index;
			tmp += 1-argList.get(index).getArgCount();
		} while (tmp > 0);
		return index;
	}
	//		***Assumes index is not the rightmost node in level.
	private int getNextInLevel(int index) {
		int tmp=0;
		do {
			tmp += argList.get(index).getArgCount() - 1;
			++index;
		} while (tmp > 0 && index < argList.size());
		return index;
	}
	/*
	//		***Assumes index is not the leftmost node of the level
	public int getPrevInLevel(int index) {
		//TODO
	}
	*/
	
	//--------------------------------------------------------------------
	// Building Methods
	public int addFunction(int index, FunctionType ftype) {
		if (!FunctionType.isFunction(ftype)) {
			throw new RuntimeException("Incorrect function to add non-function object");
		}
		else {
			if (FunctionType.isCommutative(ftype)) {
				if (getFuncType(getRoot(index)) == ftype) {
					argList.get(getRoot(index)).incrementArgCount();
					index = getNextInLevel(index);
					argList.add(index, opMaker.make(FunctionType.BLANK));
					return index;
				}
				else if (getFuncType(index) == ftype) {
					argList.get(index).incrementArgCount();
					int N = argList.get(index).getArgCount();
					++index;
					for (int i=1; i<N; ++i)
						index = getNextInLevel(index);
					argList.add(index, opMaker.make(FunctionType.BLANK));
					return index;
				}
			}
			int N = argList.get(index).getArgCount();
			argList.add(index, opMaker.make(ftype));
			
			++index;
			if (FunctionType.hasDefaultArg(ftype))
				--N;
			for (int i=1; i<N; ++i) {
				// To implement addFunctionReverse, remove next line
				index = getNextInLevel(index);
				argList.add(index, opMaker.make(FunctionType.BLANK));
			}
			if (FunctionType.hasDefaultArg(ftype)) {
				index = getNextInLevel(index);
				argList.add(index, opMaker.makeDefaultArg(ftype));
			}
		}
		return index;
	}
	
	public int addNumber(int index, double d) {
		if (getFuncType(index) == FunctionType.BLANK
				|| getFuncType(index) == FunctionType.NUMBER)
			argList.set(index, opMaker.number(d).make(FunctionType.NUMBER));
		else
			throw new RuntimeException("Cannot replace operator with Number");
		return index;
	}
	
	public int removeFunction(int index) {
		if (getFuncType(index) != FunctionType.BLANK) {
			boolean b = FunctionType.isCommutative(getFuncType(getRoot(index)))
					&& argList.get(getRoot(index)).getArgCount() > 2;
			if (b)
				argList.get(getRoot(index)).decrementArgCount();
			int N = argList.get(index).getArgCount();
			int end = index;
			argList.remove(index);
			for (int i=0; i<N; ++i)
				end = getNextInLevel(end);
			argList.subList(index, end).clear();
			
			if (!b)
				argList.add(index, opMaker.make(FunctionType.BLANK));			
		}
		return index;
	}
}
