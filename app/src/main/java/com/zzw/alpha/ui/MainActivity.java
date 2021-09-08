/**
 * <p>Project: samsung358</p >
 * <p>Package: com.zzw.alpha.ui</p >
 * <p>File: MainActivity.java</p >
 * <p>Date: 2021/9/6/9:55.</p >
 */
package com.zzw.alpha.ui;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.ActivityMainBinding;
import com.zzw.alpha.viewmodel.MainViewModel;
import com.zzw.mvvm.base.BaseActivity;

/**
 * <p>Class: com.zzw.alpha.ui.MainActivity</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/6/9:55
 */
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showContentView();
        initView();
    }


    private void initView() {
        setNoTitle();
        setSupportActionBar(bindingView.include.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
