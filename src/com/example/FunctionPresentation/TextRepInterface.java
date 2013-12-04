package com.example.FunctionPresentation;

public interface TextRepInterface {
	public String getTextRep();
	public String getTextRep(String disp);
	public String getTextRep(String disp1, String disp2);
	public String getTextRep(String[] strList);
	
	public void setIdTag(int idTag);
	
	public void setHighlight();
	public void setSubHighlight();
	public void setNoHighlight();
	
	//public void setParentheses();
	//public void setNoParentheses();
	
	//public void setTextExpand();
	//public void setTextCompress();
}
