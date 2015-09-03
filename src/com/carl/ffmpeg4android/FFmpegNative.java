package com.carl.ffmpeg4android;
/**
 * @author: Peichen Xu
 * @since: 2015-9-3
 */
public class FFmpegNative {
	
	static {
		System.loadLibrary("avcodec-56");
		System.loadLibrary("avdevice-56");
		System.loadLibrary("avfilter-5");
		System.loadLibrary("avformat-56");
		System.loadLibrary("avutil-54");
		System.loadLibrary("swresample-1");
		System.loadLibrary("swscale-3");
		System.loadLibrary("ffmpeg_codec");
	}

	
	public native int avcodec_find_decoder(int codecID);
}
