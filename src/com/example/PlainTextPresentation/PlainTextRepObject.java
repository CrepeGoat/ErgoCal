package com.example.PlainTextPresentation;
import com.example.FunctionPresentation.TextRepInterface;

public final class PlainTextRepObject implements TextRepInterface{

	private String prefix, infix, suffix;

	public PlainTextRepObject(String p, String i, String s)
	{
		prefix = new String(p);
		infix = new String(i);
		suffix = new String(s);
	}
	
	public String getTextRep()
	{
		return infix;
	}
	
	public String getTextRep(String disp)
	{
		return prefix + disp + suffix;
	}
	
	public String getTextRep(String disp1, String disp2)
	{
		return prefix + disp1 + infix + disp2 + suffix;
	}
	
	public String getTextRep(String[] strList)
	{
		String temp = prefix + strList[0];
		
		//Note - assumes that there is AT LEAST 1 string in list
		for (int i=1; i<strList.length; ++i)
			temp = temp + infix + strList[i];
		temp = temp + suffix;
		
		return temp;
	}
	
	public void setHighlight() {}
	
	public void setSubHighlight() {}

	public void setNoHighlight() {}

	
}
