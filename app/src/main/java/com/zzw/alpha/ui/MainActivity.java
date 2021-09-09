/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui</p >
 * <p>File: MainActivity.java</p >
 * <p>Date: 2021/9/6/9:55.</p >
 */
package com.zzw.alpha.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.ActivityMainBinding;
import com.zzw.alpha.view.MyFragmentPagerAdapter;
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
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> implements View.OnClickListener {
    private ViewPager vpContent;
    private ImageView ivTitleTwo;
    private ImageView ivTitleOne;
    private ImageView ivTitleThree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showContentView();
        initView();
        initContentFragment();
        initDrawerLayout();
    }

    private void initDrawerLayout() {
        //TODO
    }

    private void initContentFragment() {
        // 使用的是：getSupportFragmentManager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        vpContent.setOffscreenPageLimit(2);
        OnMyPageChangeListener onMyPageChangeListener = new OnMyPageChangeListener();
        vpContent.addOnPageChangeListener(onMyPageChangeListener);
        setCurrentItem(0);
    }


    private void initView() {
        setNoTitle();
        setSupportActionBar(bindingView.include.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
        vpContent = bindingView.include.vpContent;
        ivTitleOne = bindingView.include.ivTitleOne;
        ivTitleTwo = bindingView.include.ivTitleTwo;
        ivTitleThree = bindingView.include.ivTitleThree;
        ivTitleOne.setOnClickListener(this);
        ivTitleTwo.setOnClickListener(this);
        ivTitleThree.setOnClickListener(this);
        bindingView.include.ivTitleMenu.setOnClickListener(this);
    }

    /**
     * 切换页面
     *
     * @param position 分类角标
     */
    private void setCurrentItem(int position) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isThree = false;
        switch (position) {
            case 0:
                isOne = true;
                break;
            case 1:
                isTwo = true;
                break;
            case 2:
                isThree = true;
                break;
            default:
                isTwo = true;
                break;
        }
        vpContent.setCurrentItem(position);
        ivTitleOne.setSelected(isOne);
        ivTitleTwo.setSelected(isTwo);
        ivTitleThree.setSelected(isThree);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title_menu:
                break;
            case R.id.iv_title_one:
                if (vpContent.getCurrentItem() != 0) {
                    setCurrentItem(0);
                }
                break;
            case R.id.iv_title_two:
                // 不然cpu会有损耗
                if (vpContent.getCurrentItem() != 1) {
                    setCurrentItem(1);
                }
                break;
            case R.id.iv_title_three:
                if (vpContent.getCurrentItem() != 2) {
                    setCurrentItem(2);
                }
                break;
        }
    }

    public class OnMyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            switch (i) {
                case 0:
                    setCurrentItem(0);
                    break;
                case 1:
                    setCurrentItem(1);
                    break;
                case 2:
                    setCurrentItem(2);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
