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
import com.zzw.alpha.http.HttpClient;
import com.zzw.alpha.utils.LogUtil;
import com.zzw.mvvm.base.BaseListViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        LogUtil.debug("getWanAndroidBanner");
        final MutableLiveData<WanAndroidBannerBean> data = new MutableLiveData<>();
        Disposable subscribe = HttpClient.Builder.getWanAndroidServer().getWanAndroidBanner().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WanAndroidBannerBean>() {
                    @Override
                    public void accept(WanAndroidBannerBean bannerBean) throws Exception {
                        if (bannerBean != null && bannerBean.getData() != null
                                && bannerBean.getData().size() >= 0) {
                            data.setValue(bannerBean);
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        addDisposable(subscribe);
        return data;
    }

}
