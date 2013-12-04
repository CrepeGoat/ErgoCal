package com.example.ergocal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;

import com.example.FunctionTree.*;
import com.example.FunctionExtras.CalculationException;
import com.example.FunctionExtras.FunctionID;
import com.example.FunctionPresentation.*;
import com.example.PlainTextPresentation.*;

public class MainActivity extends Activity implements View.OnClickListener {
	
	// Declare Logic Elements
	private FunctionSource sourceObj;
	private FunctionObjectBase selectedObj;
	private FunctionObjectMaker objMaker;
	
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
	EditText ansField;

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
		ansField = (EditText) findViewById(R.id.ansField);
		
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
				// TODO Auto-generated method stub
			    if (actionId == EditorInfo.IME_ACTION_DONE) {
			    	// do your stuff here
			    	try {
			    		double num = Double.parseDouble(numField.getText());
				    	ansField.setVisibility(0);
						numField.setVisibility(2);
						if (selectedObj.getFID() == FunctionID.NUMBER)
							((FunctionNumber)selectedObj).set(num);
						else
						{
							selectedObj.getRoot().replaceArg(selectedObj,
									objMaker.number(num).make(FunctionID.NUMBER));
							objMaker.clear();
						}
			    	} catch (NumberFormatException e) {
			    		//TODO raise alert
			    	}
					
			    }
			    return false;
			}
		});
		
		objMaker = new FunctionObjectMaker(new PlainTextRepMaker());
		sourceObj = (FunctionSource)objMaker.make(FunctionID.SOURCE);
		selectedObj = sourceObj.getArg();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void setSelectObj(FunctionObjectBase target)
    {
    	//TODO
    	//selectedObj
    }
    
    public void insertNewAtSelection(FunctionID ftype)
    {
    	FunctionObjectBase rootObj = selectedObj.getRoot();
    	FunctionObjectBase newObj = objMaker.make(ftype);
    	rootObj.replaceArg(selectedObj, objMaker.make(ftype));
    	setSelectObj
    }
    
    @Override
	public void onClick(View v) {
    	// defines the button that has been clicked and performs the
		// corresponding operation
    	objMaker.clear();
		switch (v.getId()) {
		
		case R.id.btnEql:
			double ans;
			try {
				ans = sourceObj.calculate();
				ansField.setText(String.valueOf(ans));
			} catch (CalculationException ce){
				setSelectObj(ce.getCauseObject());
				//TODO Print warning to screen w/ string
				//"One or more objects uninitialized"
				ansField.setText("");
			};
			break;
			
		case R.id.btnNum:
			if (selectedObj.getFID() == FunctionID.BLANK)
			{
				//TODO bring up pop-up keyboard
				//(On completion of number, replace BLANK with NUMBER,
				//	and store value. Raise exception on incoherent number input.)

				ansField.setVisibility(2);
				
				numField.setVisibility(0);
				numField.setEnabled(true);
				numField.setFocusable(true);
				numField.setImeOptions(EditorInfo.IME_ACTION_DONE);
				
			}
			break;
		
		case R.id.btnAdd:
			// When Add button is clicked...
			if (selectedObj.getRoot().getFID() == FunctionID.ADD)
				((FunctionNArgument)selectedObj.getRoot())
					.addArg(objMaker.make(FunctionID.BLANK));
			else if (selectedObj.getFID() == FunctionID.ADD)
				((FunctionNArgument)selectedObj)
					.addArg(objMaker.make(FunctionID.BLANK));
			else
			{
				objMaker.arg(selectedObj);
				selectedObj.getRoot().replaceArg(selectedObj,
						objMaker.make(FunctionID.ADD));
			}
			break;
			
		case R.id.btnSub:
			// When Sub button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().replaceArg(selectedObj,
					objMaker.make(FunctionID.SUBTRACT));
			break;
			
		case R.id.btnMult:
			// When Mult button is clicked...
			if (selectedObj.getRoot().getFID() == FunctionID.MULTIPLY)
				((FunctionNArgument)selectedObj.getRoot())
					.addArg(objMaker.make(FunctionID.BLANK));
			else if (selectedObj.getFID() == FunctionID.MULTIPLY)
				((FunctionNArgument)selectedObj)
					.addArg(objMaker.make(FunctionID.BLANK));
			else
			{
				objMaker.arg(selectedObj);
				selectedObj.getRoot().replaceArg(selectedObj,
						objMaker.make(FunctionID.MULTIPLY));
			}			
			break;
			
		case R.id.btnDiv:
			// When Div button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().replaceArg(selectedObj,
					objMaker.make(FunctionID.DIVIDE));
			break;
			
		case R.id.btnPow:
			// When Pow button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().replaceArg(selectedObj,
					objMaker.make(FunctionID.POWER));
			break;
			
		case R.id.btnSqr:
			// When Sqr button is clicked...
			objMaker.number(2.0);
			objMaker.arg(selectedObj).arg2(objMaker.make(FunctionID.NUMBER));
			selectedObj.getRoot().replaceArg(selectedObj,
					objMaker.make(FunctionID.SQUARE));
			break;
			
		case R.id.btnSqrt:
			// When Sqrt button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().replaceArg(selectedObj,
					objMaker.make(FunctionID.SQRT));
			break;

		default:
			break;
		}
		objMaker.clear();
    }
    
}
