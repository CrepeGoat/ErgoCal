package com.example.FunctionPresentation;

public class TagBox {
	private int activationFlag;
	private boolean flagCase;
	private String tag;
	protected String insert;
	
	public TagBox (int flag, boolean c, String t, String i) {
		activationFlag = flag;
		flagCase = c;
		tag = t;
		insert = i;
	}
	
	public boolean isActive(int flags) {
		return flagCase == ((flags | activationFlag) != 0);
	}
	public boolean isIdTag() {
		return false;
	}
	public String getTag() {
		return tag;
	}
	
	public String replaceTags(int flags, String input) {
		return input.replaceAll(tag, insert);
		
	}
}
