/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.http</p >
 * <p>File: HttpUtils.java</p >
 * <p>Date: 2021/9/15/15:52.</p >
 */
package com.zzw.mvvm.http;

import android.content.Context;

import com.zzw.mvvm.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        builder.client(getOkClient())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder;
    }

    private OkHttpClient getOkClient() {
        OkHttpClient client = getUnSafeOkHttpClient();
        return client;
    }

    private OkHttpClient getUnSafeOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                //Log日志打印
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.DEBUG ?
                                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE));

        return okHttpClient.build();
    }
}
