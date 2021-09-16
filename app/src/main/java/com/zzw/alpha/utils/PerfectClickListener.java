/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.alpha.utils</p >
 * <p>File: PerfectClickListener.java</p >
 * <p>Date: 2021/9/16/16:15.</p >
 */
package com.zzw.alpha.utils;

import android.view.View;

import java.util.Calendar;

/**
 * <p>Class: com.zzw.alpha.utils.PerfectClickListener</p >
 * <p>Description:</p >
 * <pre>
 *   避免在1秒内出发多次点击
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/16/16:15
 */
public abstract class PerfectClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = v.getId();
        if (id != mId) {
            id = mId;
            lastClickTime = currentTime;
            onNoDoubleClick(v);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View v);
}
