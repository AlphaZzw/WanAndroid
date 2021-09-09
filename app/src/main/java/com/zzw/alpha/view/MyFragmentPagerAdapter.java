/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.view</p >
 * <p>File: MyFragmentPagerAdapter.java</p >
 * <p>Date: 2021/9/9/14:36.</p >
 */
package com.zzw.alpha.view;

import android.text.Html;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zzw.alpha.ui.Gank.GankFragment;
import com.zzw.alpha.ui.film.FilmFragment;
import com.zzw.alpha.ui.wan.WanCenterFragment;
import com.zzw.alpha.ui.wan.WanFragment;

import java.util.List;

/**
 * <p>Class: com.zzw.alpha.view.MyFragmentPagerAdapter</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/14:36
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragment;
    private List<String> mTitleList;
    private SparseArray<Fragment> mRegisteredFragments = new SparseArray<Fragment>();

    /**
     * construction
     */
    public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    /**
     * 接收首页传递的标题
     */
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragment, List<String> titleList) {
        super(fm);
        this.mFragment = fragment;
        this.mTitleList = titleList;
    }


    @NonNull
    @Override
    public Fragment getItem(int i) {
        if (mFragment != null) {
            return mFragment.get(i);
        } else {
            switch (i) {
                case 0:
                    return new WanFragment();
                case 1:
                    return new WanCenterFragment();
                case 2:
                    return new GankFragment();
                default:
                    return new FilmFragment();
            }
        }
    }

    @Override
    public int getCount() {
        return mFragment != null ? mFragment.size() : 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mRegisteredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mRegisteredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public SparseArray<Fragment> getmRegisteredFragments() {
        return mRegisteredFragments;
    }

    /**
     * 首页显示title，每日推荐等..
     * 若有问题，移到对应单独页面
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null && position < mTitleList.size()) {
            return Html.fromHtml(mTitleList.get(position));
        } else {
            return "";
        }
    }
}
