package com.example.PlainTextPresentation;
import com.example.FunctionPresentation.TextRepInterface;

public final class PlainTextRepObject implements TextRepInterface{

	private String[] strList;
	
	public PlainTextRepObject(String[] inList) {
		strList = inList;
	}
	public PlainTextRepObject(String p, String i, String s) {
		int n = 0;
		if (p != null)
			++n;
		if (i != null)
			++n;
		if (s != null)
			++n;
		strList = new String[n];

		n = 0;
		if (p != null) {
			strList[n] = p;
			++n;
		}
		if (i != null) {
			strList[n] = i;
			++n;
		}
		if (s != null) {
			strList[n] = s;
			++n;
		}
	}
		
	public String getTextRep(String[] inList)
	{
		String temp = strList[0];

		if (inList.length > 0) {
			temp += inList[0] + strList[1];
			
			if (inList.length > 1) {
				temp += inList[1];
				for (int i=2; i<inList.length; ++i) {
					temp += strList[1] + inList[i];
				}
				temp += strList[2];
			}
		}
		return temp;
	}
	
	public void setHighlight() {}
	
	public void setSubHighlight() {}

	public void setNoHighlight() {}
	
	public void setIdTag(int idTag) {}

	
}
