package com.example.ergocal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.FunctionTree.*;
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
			} catch (CalculationException ce){
				setSelectObj(ce.getCauseObject());
				//TODO Print warning to screen w/ string
				//"One or more objects uninitialized"
			};
			break;
			
		case R.id.btnNum:
			if (selectedObj.getFID() == FunctionID.BLANK)
			{
				//TODO bring up pop-up keyboard
				//(On completion of number, replace BLANK with NUMBER,
				//	and store value. Raise exception on incoherent number input.)
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
				selectedObj.getRoot().resetArg(selectedObj,
						objMaker.make(FunctionID.ADD));
			}
			break;
			
		case R.id.btnSub:
			// When Sub button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().resetArg(selectedObj,
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
				selectedObj.getRoot().resetArg(selectedObj,
						objMaker.make(FunctionID.MULTIPLY));
			}			
			break;
			
		case R.id.btnDiv:
			// When Div button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().resetArg(selectedObj,
					objMaker.make(FunctionID.DIVIDE));
			break;
			
		case R.id.btnPow:
			// When Pow button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().resetArg(selectedObj,
					objMaker.make(FunctionID.POWER));
			break;
			
		case R.id.btnSqr:
		case R.id.btnSqrt:
			// When Sqr button is clicked...
			objMaker.arg(selectedObj);
			selectedObj.getRoot().resetArg(selectedObj,
					objMaker.make(FunctionID.SQRT));
			break;
			
		default:
			break;
		}
		objMaker.clear();
    }
    
}
