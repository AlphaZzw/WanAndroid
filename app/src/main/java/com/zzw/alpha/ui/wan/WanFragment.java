/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan</p >
 * <p>File: WanFragment.java</p >
 * <p>Date: 2021/9/9/15:04.</p >
 */
package com.zzw.alpha.ui.wan;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentContentBinding;
import com.zzw.alpha.ui.wan.child.HomeFragment;
import com.zzw.alpha.ui.wan.child.TreeFragment;
import com.zzw.alpha.ui.wan.child.WanFindFragment;
import com.zzw.alpha.view.MyFragmentPagerAdapter;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

import java.util.ArrayList;

/**
 * <p>Class: com.zzw.alpha.ui.wan.WanFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/15:04
 */
public class WanFragment extends BaseFragment<NoViewModel, FragmentContentBinding> {
    private final ArrayList<String> mTitleList = new ArrayList<>(3);
    private final ArrayList<Fragment> mFragments = new ArrayList<>(3);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showLoading();
        initFragmentList();
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         */
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitleList);
        bindingView.vpGank.setAdapter(adapter);
        // 左右预加载页面的个数
        bindingView.vpGank.setOffscreenPageLimit(2);
        adapter.notifyDataSetChanged();
        bindingView.tabGank.setupWithViewPager(bindingView.vpGank);
        showContentView();
    }

    private void initFragmentList() {
        mTitleList.clear();
        mTitleList.add("玩安卓");
        mTitleList.add("发现");
        mTitleList.add("体系");
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(WanFindFragment.newInstance());
        mFragments.add(TreeFragment.newInstance());
    }

    @Override
    public int setContent() {
        return R.layout.fragment_content;
    }


}
