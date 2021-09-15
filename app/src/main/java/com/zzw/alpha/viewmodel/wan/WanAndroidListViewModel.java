/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.viewmodel.wan</p >
 * <p>File: WanAndroidListViewModel.java</p >
 * <p>Date: 2021/9/15/15:33.</p >
 */
package com.zzw.alpha.viewmodel.wan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.zzw.alpha.bean.wanandroid.WanAndroidBannerBean;
import com.zzw.mvvm.base.BaseListViewModel;

/**
 * <p>Class: com.zzw.alpha.viewmodel.wan.WanAndroidListViewModel</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/15:33
 */
public class WanAndroidListViewModel extends BaseListViewModel {
    public WanAndroidListViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<WanAndroidBannerBean> getWanAndroidBanner() {
        final MutableLiveData<WanAndroidBannerBean> data = new MutableLiveData<>();

        return data;
    }

}
