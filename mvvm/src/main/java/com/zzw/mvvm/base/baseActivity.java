/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.base</p >
 * <p>File: baseActivity.java</p >
 * <p>Date: 2021/9/7/18:01.</p >
 */
package com.zzw.mvvm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;

import com.zzw.mvvm.R;
import com.zzw.mvvm.databinding.ActivityBaseBinding;

import io.reactivex.disposables.CompositeDisposable;

/**
 * <p>Class: com.zzw.mvvm.base.baseActivity</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/7/18:01
 */
public abstract class baseActivity<VM extends AndroidViewModel, SV extends ViewDataBinding> extends AppCompatActivity {
    // ViewModel
    protected VM viewModel;
    // 布局view
    protected SV bindingView;
    private CompositeDisposable mCompositeDisposable;
    private View errorView;
    private View loadingView;
    private ActivityBaseBinding mBaseBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        bindingView = DataBindingUtil.inflate(LayoutInflater.from(this), layoutResID, null, false);

        //content

    }
}
