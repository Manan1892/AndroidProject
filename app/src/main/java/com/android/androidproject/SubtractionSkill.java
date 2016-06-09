package com.android.androidproject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SubtractionSkill extends Activity{

	Button bHome,bNext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.learnsub);
		
		initialize();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	/*
	 * @param v
	 * private button Click
	 */
	public void btnClick(View v)
	{
		if(v.getId() == R.id.bHome)
		{
			Intent startHome = new Intent(SubtractionSkill.this, MainActivity.class);
			startActivity(startHome);
		}
		else if(v.getId() == R.id.bNextPage)
		{
			Intent stratMultilplication = new Intent(SubtractionSkill.this, MultiplicationSkill.class);
			startActivity(stratMultilplication);
		}
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		
		bHome = (Button) findViewById(R.id.bHome);
		bNext = (Button) findViewById(R.id.bNextPage);
		
	}
}
