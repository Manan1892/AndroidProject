package com.android.androidproject;

import android.app.Activity;
import android.os.Bundle;

public class AboutUs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.aboutus);
		setContentView(R.layout.AboutUs);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}