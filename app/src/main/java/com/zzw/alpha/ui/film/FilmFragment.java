/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.ui.film</p >
 * <p>File: FilmFragment.java</p >
 * <p>Date: 2021/9/9/15:07.</p >
 */
package com.zzw.alpha.ui.film;

import com.zzw.alpha.R;
import com.zzw.alpha.databinding.FragmentContentBinding;
import com.zzw.mvvm.base.BaseFragment;
import com.zzw.mvvm.base.NoViewModel;

/**
 * <p>Class: com.zzw.alpha.ui.film.FilmFragment</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/9/15:07
 */
public class FilmFragment extends BaseFragment<NoViewModel, FragmentContentBinding> {
    @Override
    public int setContent() {
        return R.layout.fragment_content;
    }
}
