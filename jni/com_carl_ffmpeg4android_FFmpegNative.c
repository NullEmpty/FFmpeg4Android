#include <jni.h>
#include <math.h>
#include <libavutil/opt.h>
#include <libavcodec/avcodec.h>
#include <libavutil/channel_layout.h>
#include <libavutil/common.h>
#include <libavutil/imgutils.h>
#include <libavutil/mathematics.h>
#include <libavutil/samplefmt.h>

#include <android/log.h>
#define LOGE(format, ...)  __android_log_print(ANDROID_LOG_ERROR, "(>_<)", format, ##__VA_ARGS__)
#define LOGI(format, ...)  __android_log_print(ANDROID_LOG_INFO,  "(^_^)", format, ##__VA_ARGS__)

#include "com_carl_ffmpeg4android_FFmpegNative.h"

#include "ffmpeg.h"

#ifdef __cplusplus
extern "C" {
#endif

int ffmpegmain(int argc, char **argv);

//Output FFmpeg's av_log()
void custom_log(void *ptr, int level, const char* fmt, va_list vl) {

	//To TXT file

	FILE *fp = fopen("/sdcard/av_log.txt", "a+");
	if (fp) {
		vfprintf(fp, fmt, vl);
		fflush(fp);
		fclose(fp);
	}
	//To Logcat
	//LOGE(fmt, vl);
}

JNIEXPORT jint Java_com_carl_ffmpeg4android_FFmpegNative_avcodec_1find_1decoder(
		JNIEnv *env, jobject obj, jint codecID) {

	av_log_set_callback(custom_log);
	AVCodec *codec = NULL;

	/*register all formats and codecs */
//	av_register_all();
//
//	codec = avcodec_find_decoder(codecID);

	char *a[] = { "ffmpeg", "-i", "/sdcard/test.mkv", "-an", "-vn", "-scodec",
			"copy", "/sdcard/testsub.ass" };
	int argc = 8;
	ffmpegmain(argc, a);

	return 0;
}
#ifdef __cplusplus
}
#endif
