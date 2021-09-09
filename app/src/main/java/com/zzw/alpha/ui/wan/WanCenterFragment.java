/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.wan</p >
 * <p>File: WanCenterFragment.java</p >
 * <p>Date: 2021/9/9/15:05.</p >
 */
package com.zzw.alpha.ui.wan;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentContentBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

/**
 * <p>Class: com.zzw.alpha.ui.wan.WanCenterFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/15:05
 */
public class WanCenterFragment extends BaseFragment<NoViewModel, FragmentContentBinding> {
    @Override
    public int setContent() {
        return R.layout.fragment_content;
    }
}
