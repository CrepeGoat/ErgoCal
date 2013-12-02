package com.example.MathMLPresentation;
import com.example.FunctionPresentation.TextRepMakerInterface;
import com.example.FunctionPresentation.TextRepObject;
import com.example.FunctionTree.FunctionID;

public class MathMLTextRepMaker implements TextRepMakerInterface {

	@Override
	public TextRepObject makeTextRep(FunctionID id) {
		String prefix, midfix, suffix;
		switch(id)
		{
		case NUMBER:
			prefix = "<mn>";
			midfix = "";
			suffix = "</mn>";
			break;
		case ADD:
			prefix = "";
			midfix = "<mo>+</mo>";
			suffix = "";
			break;
		case SUBTRACT:
			prefix = "";
			midfix = "<mo>-</mo>";
			suffix = "";
			break;
		case MULTIPLY:
			prefix = "";
			midfix = "<mo>x</mo>";
			suffix = "";
			break;
		case DIVIDE:
			prefix = "<mfrac><mrow>";
			midfix = "</mrow><mrow>";
			suffix = "</mrow></mfrac>";
			break;
		case POWER:
		case SQUARE:
			prefix = "<msup>";
			midfix = "";
			suffix = "</msup>";
			break;
		case SQRT:
			prefix = "<msqrt>";
			midfix = "";
			suffix = "</msqrt>";
			break;
		default:
			prefix = "";
			midfix = "";
			suffix = "";
			break;
			
		}
		return new TextRepObject(prefix, midfix, suffix);
	}

}
