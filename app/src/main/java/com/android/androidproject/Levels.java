package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Levels extends Activity{

	RadioButton rbEasy,rbMedium,rbHard;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level);
		initialize();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		rbEasy = (RadioButton) findViewById(R.id.rbEasy);
		rbMedium = (RadioButton) findViewById(R.id.rbMedium);
		rbHard = (RadioButton) findViewById(R.id.rbHard);
		
	}
	/*
	 * @param v
	 * private btnStarttest Click
	 */
	public void btnStratTest(View v)
	{
		
		if(rbEasy.isChecked())
		{
			Intent startQuestions = new Intent(Levels.this, com.android.androidproject.Questions.class);
			startQuestions.putExtra("level", "easy");
			startActivity(startQuestions);
		}
		else if(rbMedium.isChecked())
		{
			Intent startQuestions = new Intent(Levels.this, com.android.androidproject.Questions.class);
			startQuestions.putExtra("level", "medium");
			startActivity(startQuestions);
		}
		else if(rbHard.isChecked())
		{
			Intent startQuestions = new Intent(Levels.this, com.android.androidproject.Questions.class);
			startQuestions.putExtra("level", "hard");
			startActivity(startQuestions);
		}
		
	}

}
