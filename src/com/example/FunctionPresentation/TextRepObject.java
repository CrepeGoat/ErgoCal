package com.example.FunctionPresentation;

public final class TextRepObject {

	private String prefix, midfix, suffix;

	public TextRepObject(String p, String m, String s)
	{
		prefix = new String(p);
		midfix = new String(m);
		suffix = new String(s);
	}
	
	public String getTextRep(String disp)
	{
		return prefix + disp + suffix;
	}
	
	public String getTextRep(String disp1, String disp2)
	{
		return prefix + disp1 + midfix + disp2 + suffix;
	}
	
	public String getTextRep(String[] strList)
	{
		String temp = prefix + strList[0];
		
		//Note - assumes that there is AT LEAST 1 string in list
		for (int i=1; i<strList.length; ++i)
			temp = temp + midfix + strList[i];
		temp = temp + suffix;
		
		return temp;
	}
	

}
