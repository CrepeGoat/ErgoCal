package com.example.PlainTextPresentation;

import com.example.FunctionExtras.FunctionType;
import com.example.FunctionPresentation.*;

public class PlainTextRepMaker implements TextRepMakerInterface {

	@Override
	public TextRepInterface[] makeTextRep(FunctionType id) {
		
		String op;
		boolean loc;
		
		boolean PRE = true;
		boolean IN = false;
				
		switch(id)
		{
		case BLANK:
			return new TextRepObject[]{
					new TextRepObject(null, "\u2610", null, new TagBox[0])};
		case SOURCE:
		case NUMBER:
			return new TextRepObject[]{
					new TextRepObject("",null,"", new TagBox[0])};
		case ADD:
			op = "+";
			loc = IN;
			break;
		case SUBTRACT:
			op = "-";
			loc = IN;
			break;
		case MULTIPLY:
			op = "\u00D7";
			loc = IN;
			break;
		case DIVIDE:
			op = "\u00F7";
			loc = IN;
			break;
		case POWER:
		case SQUARE:
			op = "^";
			loc = IN;
			break;
		case SQRT:
			op = "\u221A(";
			loc = PRE;
		default:
			return null;
		}
		
		if (loc == IN)
			return new TextRepObject[]{
					new TextRepObject("\\p1", op, "\\p2", new TagBox[]{
							new TagBox(TextRepObject.PARENTHESES,true,"\\p1","("),
							new TagBox(TextRepObject.PARENTHESES,true,"\\p2",")"),
							new TagBox(TextRepObject.PARENTHESES,false,"\\p1",""),
							new TagBox(TextRepObject.PARENTHESES,false,"\\p2","")
						})
					};
		else
			return new TextRepObject[]
					{new TextRepObject(op, null, ")", new TagBox[0])};
	}

}
