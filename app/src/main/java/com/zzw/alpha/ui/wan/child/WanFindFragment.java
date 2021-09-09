/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan.child</p >
 * <p>File: WanFindFragment.java</p >
 * <p>Date: 2021/9/9/17:11.</p >
 */
package com.zzw.alpha.ui.wan.child;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentWanFindBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

/**
 * <p>Class: com.zzw.alpha.ui.wan.child.WanFindFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/17:11
 */
public class WanFindFragment extends BaseFragment<NoViewModel, FragmentWanFindBinding> {
    public static WanFindFragment newInstance() {
        return new WanFindFragment();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_wan_find;
    }
}
