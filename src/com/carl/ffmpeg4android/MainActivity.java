package com.carl.ffmpeg4android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mTxv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTxv = (TextView) findViewById(R.id.txv);

		mTxv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							FFmpegNative ff = new FFmpegNative();
							int r = ff.avcodec_find_decoder(28);
							Log.e("MainActivity", "result:" + r);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});

	}

}
