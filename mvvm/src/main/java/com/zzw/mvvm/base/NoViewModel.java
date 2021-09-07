/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.base</p >
 * <p>File: NoViewModel.java</p >
 * <p>Date: 2021/9/7/16:38.</p >
 */
package com.zzw.mvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * <p>Class: com.zzw.mvvm.base.NoViewModel</p >
 * <p>Description: 没有viewModel的情况</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/7/16:38
 */
public class NoViewModel extends AndroidViewModel {

    private CompositeDisposable mCompositeDisposable;

    public NoViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * addDisposed
     *
     * @param disposable
     */
    protected void addDisposed(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
    }
}
