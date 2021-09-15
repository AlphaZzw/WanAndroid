/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.http</p >
 * <p>File: HttpUtils.java</p >
 * <p>Date: 2021/9/15/15:52.</p >
 */
package com.zzw.mvvm.http;

import android.content.Context;

import retrofit2.Retrofit;

/**
 * <p>Class: com.zzw.mvvm.http.HttpUtils</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/15:52
 */
public class HttpUtils {
    private static HttpUtils instance;
    private Context context;
    public final static String API_WAN_ANDROID = "https://www.wanandroid.com/";

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
    }

    public Retrofit.Builder getBuilder(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder;
    }
}
