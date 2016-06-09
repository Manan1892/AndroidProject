package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class AdditionSkill extends Activity {

	Button bHome, bNextPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.learnaddition);

		initialize();

	}

	

	private void initialize() {
		// TODO Auto-generated method stub

		bHome = (Button) findViewById(R.id.bHome);
		bNextPage = (Button) findViewById(R.id.bNextPage);

	}
}
