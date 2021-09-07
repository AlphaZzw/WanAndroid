/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.base</p >
 * <p>File: BaseViewModel.java</p >
 * <p>Date: 2021/9/7/16:41.</p >
 */
package com.zzw.mvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * <p>Class: com.zzw.mvvm.base.BaseViewModel</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/7/16:41
 */
public class BaseViewModel extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}
