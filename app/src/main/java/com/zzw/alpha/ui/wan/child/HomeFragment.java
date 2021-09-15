/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan.child</p >
 * <p>File: HomeFragment.java</p >
 * <p>Date: 2021/9/9/17:11.</p >
 */
package com.zzw.alpha.ui.wan.child;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentWanAndroidBinding;
import com.zzw.alpha.databinding.HeaderWanAndroidBinding;
import com.zzw.alpha.viewmodel.wan.WanAndroidListViewModel;
import com.zzw.mvvm.base.BaseFragment;

/**
 * <p>Class: com.zzw.alpha.ui.wan.child.HomeFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/17:11
 */
public class HomeFragment extends BaseFragment<WanAndroidListViewModel, FragmentWanAndroidBinding> {
    private boolean mIsPrepared;
    private boolean mIsFirst = true;
    private boolean isLoadBanner = false;
    private HeaderWanAndroidBinding headerBinding;
    // banner图的宽
    private int width;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_wan_android;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        initRefreshView();
        // 准备就绪
        mIsPrepared = true;
        loadData();
    }

    private void initRefreshView() {
        headerBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.header_wan_android, (ViewGroup) bindingView.xrvWan.getParent(), false);
        bindingView.xrvWan.addHeaderView(headerBinding.getRoot());
//        width = DensityUtil.getDisplayWidth() - DensityUtil.dip2px(bindingView.xrvWan.getContext(), 160);
//        float height = width / 1.8f;
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) height);
//        headerBinding.banner.setLayoutParams(lp);
    }

    @Override
    protected void loadData() {
        super.loadData();
        if (mIsPrepared && isLoadBanner) {
            onResume();
        }
        if (!mIsPrepared || !mIsVisible || !mIsFirst) {
            return;
        }
        bindingView.srlWan.postDelayed(this::getWanAndroidBanner, 1000);
    }

    public void getWanAndroidBanner() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
