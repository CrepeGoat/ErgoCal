package com.example.FunctionPresentation;

public final class TextRepObject implements TextRepInterface{
	
	private final String pTag1="\\p1", pTag2="\\p2";
	private String[] strList;
	private TagBox[] tagList;
	
	public TextRepObject(String[] sl, TagBox[] tl) {
		strList = sl;
		tagList = tl;
	}
	public TextRepObject(String p, String i, String s, TagBox[] tl) {
		tagList = tl;
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
		
	public String getTextRep(int flags, String... inList) {
		//Concatenates strings into single output string
		String rStr = strList[0];
		
		if (inList.length > 0) {
			rStr += inList[0] + strList[1];
			
			if (inList.length > 1) {
				rStr += inList[1];
				for (int i=2; i<inList.length; ++i) {
					rStr += strList[1] + inList[i];
				}
				rStr += strList[2];
			}
		}
		
		//replaces tags with correct strings (based on flag state)
		String p1, p2;
		if ((flags & PARENTHESES) != 0) {
			p1="(";
			p2=")";
		}
		else {
			p1="";
			p2="";
		}
		rStr = rStr.replaceAll(pTag1, p1);
		rStr = rStr.replaceAll(pTag2, p2);
		return rStr;
	}
	
	public String getTextRep(int flags, double value, String[] strList) {
		return getTextRep(flags, String.valueOf(value));
	}
	public <T> String getTextRep(int flags, T data, String[] strList) {
		throw new RuntimeException("");
	}
	
	public void setIdTag(int idTag) {
		for (TagBox t:tagList) {
			if (t.isIdTag()) {
				((IdTagBox) t).setIdTag(idTag);
				break;
			}
		}
	}

}
