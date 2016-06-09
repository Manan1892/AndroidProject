package com.android.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// ---Hiding titlebar---
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.abriowin);
		ourSong.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openHitCount = new Intent(Splash.this, HomeActivity.class);
					startActivity(openHitCount);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
