package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MultiplicationSkill extends Activity{

	Button bHome,bNext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.learnmul);
		
		initialize();
		
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}



	public void btnClick(View v)
	{
		
		if(v.getId() == R.id.bHome)
		{
			Intent startHome = new Intent(MultiplicationSkill.this, MainActivity.class);
			startActivity(startHome);
		}
		else if(v.getId() == R.id.bNextPage)
		{
			Intent startDiv = new Intent(MultiplicationSkill.this, DivisionSkill.class);
			startActivity(startDiv);
		}
		
	}


}
