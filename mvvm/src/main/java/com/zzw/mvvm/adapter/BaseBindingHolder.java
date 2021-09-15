/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.adapter</p >
 * <p>File: BaseBindingHolder.java</p >
 * <p>Date: 2021/9/15/10:45.</p >
 */
package com.zzw.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import me.jingbin.library.adapter.BaseByViewHolder;

/**
 * <p>Class: com.zzw.mvvm.adapter.BaseBindingHolder</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/15/10:45
 */
public abstract class BaseBindingHolder<T, B extends ViewDataBinding> extends BaseByViewHolder<T> {
    public final B binding;

    public BaseBindingHolder(ViewGroup viewGroup, int layoutId) {
        super(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), layoutId, viewGroup, false).getRoot());
        binding = DataBindingUtil.getBinding(this.itemView);
    }

    @Override
    protected void onBaseBindView(BaseByViewHolder<T> holder, T bean, int position) {
        onBindingView(this, bean, position);
        //防止数据闪烁
        binding.executePendingBindings();
    }

    protected abstract void onBindingView(BaseBindingHolder holder, T bean, int position);
}
