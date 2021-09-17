/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.adapter</p >
 * <p>File: WanAndroidAdapter.java</p >
 * <p>Date: 2021/9/17/15:30.</p >
 */
package com.zzw.alpha.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.zzw.alpha.R;
import com.zzw.alpha.bean.wanandroid.ArticlesBean;
import com.zzw.alpha.bean.wanandroid.WanAndroidBannerBean;
import com.zzw.alpha.databinding.ItemWanAndroidBinding;
import com.zzw.mvvm.adapter.BaseBindingAdapter;
import com.zzw.mvvm.adapter.BaseBindingHolder;

import me.jingbin.library.adapter.BaseByViewHolder;
import me.jingbin.library.adapter.BaseRecyclerAdapter;

/**
 * <p>Class: com.zzw.alpha.adapter.WanAndroidAdapter</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/17/15:30
 */
public class WanAndroidAdapter extends BaseBindingAdapter<ArticlesBean, ItemWanAndroidBinding> {

    public WanAndroidAdapter() {
        super(R.layout.item_wan_android);
    }

    @Override
    protected void bindView(BaseBindingHolder holder, ArticlesBean bean, int position, ItemWanAndroidBinding binding) {

    }


}
