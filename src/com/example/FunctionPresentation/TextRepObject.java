package com.example.FunctionPresentation;

public final class TextRepObject implements TextRepInterface{
	
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
		//replaces tags with correct strings (based on flag state)
		String[] tmpList = new String[strList.length];
		int i;
		for (i=0; i<strList.length; ++i) {
			tmpList[i] = strList[i];
		}
		for (TagBox tb:tagList) {
			if (tb.isActive(flags)) {
				for (i=0; i<tmpList.length; ++i) {
					tmpList[i] = tb.replaceTags(tmpList[i]);
				}
			}
		}

		//Concatenates strings into single output string
		String rStr = tmpList[0];
		
		if (inList.length > 0) {
			rStr += inList[0] + tmpList[1];
			
			if (inList.length > 1) {
				rStr += inList[1];
				for (i=2; i<inList.length; ++i) {
					rStr += tmpList[1] + inList[i];
				}
				rStr += tmpList[2];
			}
		}
		
		return rStr;
	}
	
	public <T> String getTextRep(int flags, T data, String[] strList) {
		if (Double.TYPE.equals(data.getClass()))
			return getTextRep(flags, String.valueOf((Double)data));
		else
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
