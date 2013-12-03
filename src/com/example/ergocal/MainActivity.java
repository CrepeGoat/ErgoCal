package com.example.ergocal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	// Initialize
	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
	Button btnPow;
	Button btnSqr;

	/** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // find the elements
        btnAdd = (Button) findViewById(R.id.btnAdd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnMult = (Button) findViewById(R.id.btnMult);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnPow = (Button) findViewById(R.id.btnPow);
		btnSqr = (Button) findViewById(R.id.btnSqr);
		
		// set a listener
		btnAdd.setOnClickListener(this);
		btnSub.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnPow.setOnClickListener(this);
		btnSqr.setOnClickListener(this);
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
	public void onClick(View v) {
    	// defines the button that has been clicked and performs the
		// corresponding operation
		switch (v.getId()) {
		
		case R.id.btnAdd:
			// When Add button is clicked...
			
			break;
		case R.id.btnSub:
			// When Sub button is clicked...
			
			break;
		case R.id.btnMult:
			// When Mult button is clicked...
			
			break;
		case R.id.btnDiv:
			// When Div button is clicked...
			
			break;
		case R.id.btnPow:
			// When Pow button is clicked...
			
			break;
		case R.id.btnSqr:
			// When Sqr button is clicked...
			
			break;
			
		default:
			break;
		}
    }
    
}
