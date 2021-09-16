/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan.child</p >
 * <p>File: HomeFragment.java</p >
 * <p>Date: 2021/9/9/17:11.</p >
 */
package com.zzw.alpha.ui.wan.child;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.zzw.alpha.R;
import com.zzw.alpha.bean.wanandroid.WanAndroidBannerBean;
import com.zzw.alpha.databinding.FragmentWanAndroidBinding;
import com.zzw.alpha.databinding.HeaderWanAndroidBinding;
import com.zzw.alpha.utils.DensityUtil;
import com.zzw.alpha.utils.GlideUtil;
import com.zzw.alpha.utils.LogUtil;
import com.zzw.alpha.utils.PerfectClickListener;
import com.zzw.alpha.viewmodel.wan.WanAndroidListViewModel;
import com.zzw.mvvm.base.BaseFragment;

import java.util.List;

import me.jingbin.sbanner.config.BannerConfig;
import me.jingbin.sbanner.config.ScaleRightTransformer;
import me.jingbin.sbanner.holder.SBannerViewHolder;

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
        width = DensityUtil.getDisplayWidth() - DensityUtil.dip2px(bindingView.xrvWan.getContext(), 160);
        float height = width / 1.8f;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) height);
        headerBinding.banner.setLayoutParams(lp);
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
        viewModel.getWanAndroidBanner().observe(this, new Observer<WanAndroidBannerBean>() {
            @Override
            public void onChanged(WanAndroidBannerBean bean) {
                if (bean != null) {
                    LogUtil.debug("showBannerVIew");
                    headerBinding.banner.setVisibility(View.VISIBLE);
                    showBannerVIew(bean.getData());
                } else {
                    headerBinding.banner.setVisibility(View.GONE);
                }
            }
        });
    }

    private void showBannerVIew(List<WanAndroidBannerBean.DataBean> data) {
        if (!isLoadBanner) {
            LogUtil.debug("showBannerVIew == > >" + data);
            headerBinding.banner.setIndicatorRes(R.drawable.banner_red, R.drawable.banner_grey)
                    .setBannerStyle(BannerConfig.NOT_INDICATOR)
                    .setBannerAnimation(ScaleRightTransformer.class)
                    .setDelayTime(6000)
                    .setOffscreenPageLimit(data.size())
                    .setAutoPlay(false)
                    .setPages(data, CustomViewHolder::new)
                    .start();
        } else {
            headerBinding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR).setAutoPlay(true);
            headerBinding.banner.update(data);
        }
    }

    class CustomViewHolder implements SBannerViewHolder<WanAndroidBannerBean.DataBean> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner_wanandroid, null);
            imageView = view.findViewById(R.id.iv_banner);
            return imageView;
        }

        @Override
        public void onBind(Context context, int position, WanAndroidBannerBean.DataBean data) {
            if (data != null) {
                DensityUtil.setWidthHeight(imageView, width, 1.8f);
                GlideUtil.displayEspImage(data.getImagePath(), imageView, 3);
                imageView.setOnClickListener(new PerfectClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {

                    }
                });
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
