package com.carl.ffmpeg4android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mTxv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTxv = (TextView) findViewById(R.id.txv);
		
		FFmpegNative ff = new FFmpegNative();
		int r = ff.avcodec_find_decoder(28);
		mTxv.setText("result:" + r);
	}

}
