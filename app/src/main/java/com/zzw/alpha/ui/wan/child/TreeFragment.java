/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan.child</p >
 * <p>File: TreeFragment.java</p >
 * <p>Date: 2021/9/9/17:12.</p >
 */
package com.zzw.alpha.ui.wan.child;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentWanAndroidBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

/**
 * <p>Class: com.zzw.alpha.ui.wan.child.TreeFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/17:12
 */
public class TreeFragment extends BaseFragment<NoViewModel, FragmentWanAndroidBinding> {
    public static TreeFragment newInstance() {
        return new TreeFragment();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_wan_android;
    }
}
