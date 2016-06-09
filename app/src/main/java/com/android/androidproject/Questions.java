package com.android.androidproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Questions extends Activity {

	Chronometer ch;
	RadioButton ans1, ans2, ans3, ans4;
	Button bSubmit, bSkip;
	String jsondata;
	TextView tv;
	int ii;
	int j = 0, k = 0;
	ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
	String uans;

	JSONArray questi = null;
	private static final String questions = "questions";
	private static final String ID = "id";
	private static final String question = "question";
	private static final String option1 = "option1";
	private static final String option2 = "option2";
	private static final String option3 = "option3";
	private static final String option4 = "option4";
	private static final String correctans = "Correctans";

@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// ---Hiding titlebar---
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.questions);

		final RadioGroup radiogrp = (RadioGroup) findViewById(R.id.radioGroup1);
		tv = (TextView) findViewById(R.id.tvQues1);
		ans1 = (RadioButton) findViewById(R.id.op1);
		ans2 = (RadioButton) findViewById(R.id.op2);
		ans3 = (RadioButton) findViewById(R.id.op3);
		ans4 = (RadioButton) findViewById(R.id.op4);
		bSubmit = (Button) findViewById(R.id.bnext);
		bSkip = (Button) findViewById(R.id.bSkip);
		ch = (Chronometer) findViewById(R.id.mChronomete);
		
		ch.start();

		for (int i = 0; i < 5; i++) {
			while (true) {
				Random random = new Random();
				int ii = random.nextInt(20);

				if (!arrayList.contains(ii)) {
					arrayList.add(ii);

					break;
				}
			}
		}
Log.e("random1", Integer.toString(arrayList.get(0)));
		Log.e("random2", Integer.toString(arrayList.get(1)));
		Log.e("random3", Integer.toString(arrayList.get(2)));
		Log.e("random4", Integer.toString(arrayList.get(3)));
		Log.e("random5", Integer.toString(arrayList.get(4)));

		// ArrayList<HashMap<String, String>> contactList = new
		// ArrayList<HashMap<String, String>>();

		Intent intent = getIntent();
		String str = intent.getStringExtra("level");

		try {
			if (str.equalsIgnoreCase("easy")) {
				jsondata = jsonToStringFromAssetFolder("Json.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Easy Selected",
						Toast.LENGTH_SHORT).show();
			} else if (str.equalsIgnoreCase("medium")) {
				jsondata = jsonToStringFromAssetFolder("jason_mid.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Medium Selected",
						Toast.LENGTH_SHORT).show();
			}
			if (str.equalsIgnoreCase("hard")) {
				jsondata = jsonToStringFromAssetFolder("json_hard.txt",
						getApplicationContext());
				Toast.makeText(getBaseContext(), "Level Hard Selected",
						Toast.LENGTH_SHORT).show();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			// Parse the data into jsonobject to get original data in form of
			// json.
			JSONObject json = new JSONObject(jsondata);
			questi = json.getJSONArray(questions);
for (int i = 0; i < questi.length(); i++) {
				JSONObject c = questi.getJSONObject(i);

				// Storing each json item in variable
				String id = c.getString(ID);
				String name = c.getString(question);
				String email = c.getString(option1);
				String address = c.getString(option2);
				String gender = c.getString(option3);
				String phone = c.getString(option4);
				final String ans = c.getString(correctans);

				if (id.toString().equals(Integer.toString(arrayList.get(j)))) {
					tv.setText(name);
					ans1.setText(email);
					ans2.setText(address);
					ans3.setText(gender);
					ans4.setText(phone);
					uans = ans.toString();

				}
	bSubmit.setOnClickListener(new OnClickListener() {

					public void onClick(View arg0) {
						// TODO Auto-generated method stub

						int selectedid = radiogrp.getCheckedRadioButtonId();

						RadioButton radiobtn = (RadioButton) findViewById(selectedid);

						Log.e("hi", radiobtn.getText().toString());

						if (radiobtn.getText().toString().equals(uans)) {
							k = k + 10;
							Toast.makeText(
									Questions.this,
									"Correct Answer,Score:"
											+ Integer.toString(k),
									Toast.LENGTH_SHORT).show();
						} else {
							k = k - 5;
							Toast.makeText(
									Questions.this,
									"Wrong Answer,Score:" + Integer.toString(k),
									Toast.LENGTH_SHORT).show();
						}
						Log.e("marks", Integer.toString(k));
						if (j == 4) {
							// Toast.makeText(Questions.this,
							// Integer.toString(k), Toast.LENGTH_SHORT).show();
							ch.stop();
							String elapsedTime = ch.getText().toString();
							Intent intent = new Intent(Questions.this,
									com.android.androidproject.Score.class);
							intent.putExtra("score", Integer.toString(k));
							intent.putExtra("time", elapsedTime);
							startActivity(intent);
						}
						j++;
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
