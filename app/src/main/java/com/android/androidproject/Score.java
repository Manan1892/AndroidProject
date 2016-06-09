package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class Score extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.score);
		
		Intent intent = getIntent();
		
		String score = intent.getStringExtra("score").toString();
		String elapsedTime = intent.getStringExtra("time").toString();
		
		Log.e("score", score);
		System.out.println(score);
		
		TextView tv = (TextView)findViewById(R.id.s);
		tv.setText("Your Score Is : " + score.toString() + "\nElapsed Time : " +elapsedTime.toString());

}
}