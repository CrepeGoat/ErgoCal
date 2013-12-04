package com.example.FunctionTree;

import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;
import java.util.HashMap;

/*
 * The interface for the function-object components which, when nested,
 * can imitate any compiled mathematical function.
 */
public abstract class FunctionObjectBase {
	protected TextRepInterface display;
	protected FunctionType fid;
	
	protected FunctionObjectBase root;
	protected short idTag;
	private static short lastTag = 0;
	private static HashMap<Short, FunctionObjectBase> tagBag
		= new HashMap<Short, FunctionObjectBase>();
	
	//Static Tag Methods
	private static short getNewTag(FunctionObjectBase fobj) {
		while (tagBag.containsKey(lastTag) == false)
			lastTag += 1;
		tagBag.put(lastTag, fobj);
		return lastTag;
	}
	
	public static FunctionObjectBase getTaggedReference(short tag) {
		return tagBag.get(tag);
	}
	
	//Constructor
	public FunctionObjectBase(FunctionType i, TextRepInterface d) {
		display = d;
		fid = i;
		root = null;
		idTag = getNewTag(this);
	}
	
	//Get root object
	public FunctionObjectBase getRoot() {
		return root;
	}
	
	//Get tag
	public short getIdTag() {
		return idTag;
	}
	
	//Get Function Tag
	public FunctionType getFID() {
		return fid;
	}
	
	//TODO A more general way of propagating Display commands
	//public void setTextRepStyle()
	
	//Close Function (i.e. de-logs tag)
	public void close() {
		tagBag.remove(idTag);
	}
	
	//Abstract Methods
	abstract public double calculate() throws CalculationException;
	abstract public int numberOfArguments();
	abstract public void replaceArg(FunctionObjectBase old, FunctionObjectBase a);

	abstract public String getTextRep();
	abstract public void setHighlight();
	abstract public void setSubHighlight();
	abstract public void setNoHighlight();
	//abstract public void setParentheses();
	//abstract public void setNoParentheses();
	//abstract public void setTextExpand();
	//abstract public void setTextCompress();
}
