/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.utils</p >
 * <p>File: BuildFactory.java</p >
 * <p>Date: 2021/9/15/15:53.</p >
 */
package com.zzw.mvvm.utils;

import com.zzw.mvvm.http.HttpUtils;

/**
 * <p>Class: com.zzw.mvvm.utils.BuildFactory</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/15:53
 */
public class BuildFactory {
    private static BuildFactory instance;
    private Object wanAndroidHttps;

    public static BuildFactory getInstance() {
        if (instance == null) {
            synchronized (BuildFactory.class) {
                if (instance == null) {
                    instance = new BuildFactory();
                }
            }
        }
        return instance;
    }

    public <T> T create(Class<T> a, String type) {
        switch (type) {
            case HttpUtils.API_WAN_ANDROID:
                if (wanAndroidHttps == null) {
                    synchronized (BuildFactory.class) {
                        if (wanAndroidHttps == null) {
                            wanAndroidHttps = HttpUtils.getInstance().getBuilder(type).build().create(a);
                        }
                    }
                }
                return (T) wanAndroidHttps;
        }
        return null;
    }

}
