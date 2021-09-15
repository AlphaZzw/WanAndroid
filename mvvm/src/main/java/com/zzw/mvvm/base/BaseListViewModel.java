/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.base</p >
 * <p>File: BaseListViewModel.java</p >
 * <p>Date: 2021/9/15/15:34.</p >
 */
package com.zzw.mvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;

/**
 * <p>Class: com.zzw.mvvm.base.BaseListViewModel</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/15:34
 */
public class BaseListViewModel extends BaseViewModel {
    public int mPage = 0;

    public BaseListViewModel(@NonNull Application application) {
        super(application);
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int mPage) {
        this.mPage = mPage;
    }
}
