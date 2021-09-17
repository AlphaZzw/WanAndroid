/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.view</p >
 * <p>File: BaseRecycleViwq.java</p >
 * <p>Date: 2021/9/14/9:59.</p >
 */
package com.zzw.mvvm.adapter;

import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import java.util.List;

import me.jingbin.library.adapter.BaseByRecyclerViewAdapter;

/**
 * <p>Class: com.zzw.mvvm.view.BaseRecycleViwq</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/14/9:59
 */
public abstract class BaseBindingAdapter<T, B extends ViewDataBinding> extends BaseByRecyclerViewAdapter<T, BaseBindingHolder<T, B>> {

    private int mLayoutId;

    public BaseBindingAdapter(@LayoutRes int layoutId) {
        mLayoutId = layoutId;
    }

    public BaseBindingAdapter(@LayoutRes int layoutId, List<T> data) {
        super(data);
        mLayoutId = layoutId;
    }

    @NonNull
    @Override
    public BaseBindingHolder<T, B> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent, mLayoutId);
    }

    private class ViewHolder extends BaseBindingHolder<T, B> {

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        protected void onBindingView(BaseBindingHolder holder, T bean, int position) {
            bindView(holder, bean, position, binding);
        }
    }

    protected abstract void bindView(BaseBindingHolder holder, T bean, int position, B binding);
}
