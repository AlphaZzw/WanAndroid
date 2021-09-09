/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.Gank</p >
 * <p>File: GankFragment.java</p >
 * <p>Date: 2021/9/9/15:06.</p >
 */
package com.zzw.alpha.ui.Gank;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentContentBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

/**
 * <p>Class: com.zzw.alpha.ui.Gank.GankFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/15:06
 */
public class GankFragment extends BaseFragment<NoViewModel, FragmentContentBinding> {
    @Override
    public int setContent() {
        return R.layout.fragment_content;
    }
}
