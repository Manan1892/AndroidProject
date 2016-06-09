package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LessGraeterThan extends Activity{

	Button bHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.lessgreaterthan);
		bHome = (Button) findViewById(R.id.bHome);
	}

	public void btnClick(View v)
	{
		if(v.getId() == R.id.bHome)
		{
			Intent startHome = new Intent(LessGraeterThan.this, MainActivity.class);
			startActivity(startHome);
		}
	}


	}
	
	
}