/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan.child</p >
 * <p>File: HomeFragment.java</p >
 * <p>Date: 2021/9/9/17:11.</p >
 */
package com.zzw.alpha.ui.wan.child;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentWanAndroidBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

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
public class HomeFragment extends BaseFragment<NoViewModel, FragmentWanAndroidBinding> {
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_wan_android;
    }
}
