package com.example.PlainTextPresentation;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.TextRepInterface;
import com.example.FunctionPresentation.TextRepMakerInterface;

public class PlainTextRepMaker implements TextRepMakerInterface {

	@Override
	public TextRepInterface makeTextRep(FunctionType id) {
		
		String op;
		boolean loc;
		
		boolean PRE = true;
		boolean IN = false;
		
		switch(id)
		{
		case BLANK:
			return new PlainTextRepObject(null, "  ", null);
		case SOURCE:
		case NUMBER:
			return new PlainTextRepObject("",null,"");
		case ADD:
			op = "+";
			loc = IN;
			break;
		case SUBTRACT:
			op = "-";
			loc = IN;
			break;
		case MULTIPLY:
			op = "x";
			loc = IN;
			break;
		case DIVIDE:
			op = "/";
			loc = IN;
			break;
		case POWER:
		case SQUARE:
			op = "^";
			loc = IN;
			break;
		case SQRT:
			op = "sqrt(";
			loc = PRE;
		default:
			return null;
		}
		
		if (loc == IN)
			return new PlainTextRepObject("(", op, ")");
		else
			return new PlainTextRepObject(op, null, ")");
	}

}
