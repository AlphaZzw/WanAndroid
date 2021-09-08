/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.base</p >
 * <p>File: RootApplication.java</p >
 * <p>Date: 2021/9/8/11:38.</p >
 */
package com.zzw.mvvm.base;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

/**
 * <p>Class: com.zzw.mvvm.base.RootApplication</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/8/11:38
 */
public class RootApplication extends MultiDexApplication {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    public static Context getContext() {
        return mContext;
    }
}
