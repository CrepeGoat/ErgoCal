package com.example.FunctionPresentation;

public class IdTagBox extends TagBox {

	public IdTagBox(String t) {
		super(0, false, t, "");
	}
	
	public boolean isIdTag() {
		return false;
	}
	public void setIdTag(int idTag) {
		insert = String.valueOf(idTag);
	}

}
