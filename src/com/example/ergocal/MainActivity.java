package com.example.ergocal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;

import com.example.OperatorStack.*;
import com.example.FunctionExtras.*;
import com.example.PlainTextPresentation.*;

public class MainActivity extends Activity implements View.OnClickListener {
	
	// Declare Logic Elements
	private OperatorStack opStack;
	private int selectionIndex;
	
	// Initialize Buttons
	Button btnEql;
	Button btnNum;
	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
	Button btnPow;
	Button btnSqr;
	Button btnSqrt;
	
	// Initialize Edit Text
	EditText numField;
	TextView ansField;
	
	private void setHelperMessage(String str) {
		Toast t = Toast.makeText(
				getApplicationContext(),
				str,
				Toast.LENGTH_SHORT);
		t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
		t.show();

	}

	/** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // find the elements
        btnEql = (Button) findViewById(R.id.btnEql);
        btnNum = (Button) findViewById(R.id.btnNum);
        btnAdd = (Button) findViewById(R.id.btnAdd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnMult = (Button) findViewById(R.id.btnMult);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnPow = (Button) findViewById(R.id.btnPow);
		btnSqr = (Button) findViewById(R.id.btnSqr);
		btnSqrt = (Button) findViewById(R.id.btnSqrt);
		
		numField = (EditText) findViewById(R.id.numField);
		ansField = (TextView) findViewById(R.id.ansField);
		numField.setText("");
		ansField.setText("");

		// set a listener
		btnEql.setOnClickListener(this);
		btnNum.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		btnSub.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnPow.setOnClickListener(this);
		btnSqr.setOnClickListener(this);
		btnSqrt.setOnClickListener(this);
		
		numField.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			    if (actionId == EditorInfo.IME_ACTION_DONE) {
			    	// do your stuff here
			    	try {
			    		double num = Double.parseDouble(numField.getText().toString());
				    	ansField.setVisibility(0);
						numField.setVisibility(2);
						opStack.setNumber(selectionIndex, num);
						numField.setText("");
			    	} catch (NumberFormatException e) {
			    		setHelperMessage("Invalid number input");
			    	} catch (AssignmentException e) {
			    		throw new RuntimeException
			    				("Invalid target for number assignment");
			    	}
			    }
			    return false;
			}
		});
		
		opStack = new OperatorStack(new PlainTextRepMaker());
		selectionIndex = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void setSelectionIndex(int target) {
    	if (selectionIndex != 0)
    		opStack.unsetTextHighlight(selectionIndex);
    	
    	selectionIndex = target;
    	
    	if (selectionIndex != 0)
    		opStack.setTextHighlight(selectionIndex);
    }
    
    @Override
	public void onClick(View v) {
    	// defines the button that has been clicked and performs the
		// corresponding operation
		switch (v.getId()) {
		
		case R.id.btnEql:
			try {
				double ans = opStack.getResult();
				ansField.setText(String.valueOf(ans));
			} catch (CalculationException ce){
				setSelectionIndex((Integer)ce.getCauseObject());
				setHelperMessage("One or more operator fields uninitialized");
				ansField.setText("");
			};
			break;
			
		case R.id.btnNum:
			if (opStack.getFuncType(selectionIndex) == FunctionType.BLANK
					|| opStack.getFuncType(selectionIndex) == FunctionType.NUMBER) {
				//TODO bring up pop-up keyboard
				//(On completion of number, replace BLANK with NUMBER,
				//	and store value. Raise exception on incoherent number input.)

				ansField.setVisibility(2);
				
				numField.setVisibility(0);
				numField.setEnabled(true);
				numField.setFocusable(true);
				numField.setImeOptions(EditorInfo.IME_ACTION_DONE);
				
			}
			else
				setHelperMessage("Invalid target for number assignment");
			break;
		
		case R.id.btnAdd:
			// When Add button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.ADD));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnSub:
			// When Sub button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.SUBTRACT));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnMult:
			// When Mult button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.MULTIPLY));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnDiv:
			// When Div button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.DIVIDE));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnPow:
			// When Pow button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.POWER));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnSqr:
			// When Sqr button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.SQUARE));
			numField.setText(opStack.getTextRep());
			break;
			
		case R.id.btnSqrt:
			// When Sqrt button is clicked...
			setSelectionIndex(opStack.addFunction(selectionIndex, FunctionType.SQRT));
			numField.setText(opStack.getTextRep());
			break;

		default:
			break;
		}

    }
    
}
