/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.http</p >
 * <p>File: HttpClient.java</p >
 * <p>Date: 2021/9/15/15:49.</p >
 */
package com.zzw.alpha.http;

import com.zzw.alpha.bean.wanandroid.WanAndroidBannerBean;
import com.zzw.mvvm.http.HttpUtils;
import com.zzw.mvvm.utils.BuildFactory;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * <p>Class: com.zzw.alpha.http.HttpClient</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/15:49
 */
public interface HttpClient {

    class Builder {
        public static HttpClient getWanAndroidServer() {
            return BuildFactory.getInstance().create(HttpClient.class, HttpUtils.API_WAN_ANDROID);
        }
    }

    /**
     * ----------------------------------------interface-----------------------------------------------
     **/


    @GET("banner/json")
    Observable<WanAndroidBannerBean> getWanAndroidBanner();
}
