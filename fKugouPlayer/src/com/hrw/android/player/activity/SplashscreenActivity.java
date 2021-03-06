package com.hrw.android.player.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hrw.android.player.R;

public class SplashscreenActivity extends Activity {
	private AnimationDrawable splashDrawable;
	MediaPlayer mp = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
//		mp = MediaPlayer.create(this, R.raw.login);
//		mp.start();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				ImageView imageView = (ImageView) findViewById(R.id.splash_anim);
				splashDrawable = (AnimationDrawable) imageView.getDrawable();
				splashDrawable.start();
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent mainIntent = new Intent(
								SplashscreenActivity.this, HomeActivity.class);
						SplashscreenActivity.this.startActivity(mainIntent);
						HomeActivity.launch(SplashscreenActivity.this);
						SplashscreenActivity.this.finish();
					}
				}, 2000);// 2000为间隔的时间-毫秒
			}
		}, 50);// 50为间隔的时间-毫秒
	}

}
