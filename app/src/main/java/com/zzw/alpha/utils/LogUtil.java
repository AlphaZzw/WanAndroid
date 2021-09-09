/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.utils</p >
 * <p>File: DebugUtil.java</p >
 * <p>Date: 2021/9/9/11:03.</p >
 */
package com.zzw.alpha.utils;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * <p>Class: com.zzw.alpha.utils.DebugUtil</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/11:03
 */
public class LogUtil {
    public static final String TAG = "WanAndroid";
    public static final boolean DEBUG = true;

    public static void toast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static final void debug(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static final void debug(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static final void error(String tag, String error) {

        if (DEBUG) {

            Log.e(tag, error);
        }
    }

    public static final void error(String error) {

        if (DEBUG) {

            Log.e(TAG, error);
        }
    }

    public static void isMainThread() {
        if (DEBUG) {
            Log.e(TAG, "---是否在主线程：" + (Thread.currentThread() == Looper.getMainLooper().getThread()));
        }
    }
}
