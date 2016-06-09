package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
	Button btnSignIn, btnSignUp;
	com.android.androidproject.LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// ---Hiding titlebar---
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// create a instance of SQLite Database
		loginDataBaseAdapter = new com.android.androidproject.LoginDataBaseAdapter(this);
		loginDataBaseAdapter = loginDataBaseAdapter.open();

		// Get The Refference Of Buttons
		btnSignIn = (Button) findViewById(R.id.buttonSignIN);
		btnSignUp = (Button) findViewById(R.id.buttonSignUP);
		final EditText editTextUserName = (EditText) findViewById(R.id.editTextUserNameToLogin);
		final EditText editTextPassword = (EditText) findViewById(R.id.editTextPasswordToLogin);

		// Set OnClick Listener on SignUp button
		btnSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// / Create Intent for SignUpActivity and Start The Activity
				Intent intentSignUP = new Intent(getApplicationContext(),
						com.android.androidproject.SignUPActivity.class);
				startActivity(intentSignUP);
			}
		});
		btnSignIn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// get The User name and Password
				String userName = editTextUserName.getText().toString();
				String password = editTextPassword.getText().toString();

				// fetch the Password form database for respective user name
				String storedPassword = loginDataBaseAdapter
						.getSinlgeEntry(userName);

				// check if the Stored password matches with Password entered by
				// user
				if (password.equals(storedPassword)) {
					Toast.makeText(HomeActivity.this,
							"Congrats: Login Successfull", Toast.LENGTH_LONG)
							.show();
					Intent startMainActivity = new Intent(HomeActivity.this, MainActivity.class);
					startActivity(startMainActivity);
					// dialog.dismiss();
				} else {
					Toast.makeText(HomeActivity.this,
							"User Name or Password does not match",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	// Methos to handleClick Event of Sign In Button
	public void signIn(View V) {
		/*
		 * final Dialog dialog = new Dialog(HomeActivity.this);
		 * dialog.setContentView(R.layout.login); dialog.setTitle("Login");
		 * 
		 * // get the Refferences of views final EditText
		 * editTextUserName=(EditText
		 * )dialog.findViewById(R.id.editTextUserNameToLogin); final EditText
		 * editTextPassword
		 * =(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);
		 * 
		 * Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);
		 */

		// get the Refferences of views

		// Set On ClickListener

		// dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Close The Database
		loginDataBaseAdapter.close();
	}
}
