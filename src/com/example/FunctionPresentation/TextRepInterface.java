package com.example.FunctionPresentation;

public interface TextRepInterface {
	public static final byte SUBHIGHLIGHT = 1;
	public static final byte HIGHLIGHT = 2;
	public static final byte PARENTHESES = 4;	
	public static final byte EXPAND_EXP = 8;

	public <T> String getTextRep(int flags, T data, String[] strList);
	public String getTextRep(int flags, String... strList);
	
	public void setIdTag(int idTag);
	
}
