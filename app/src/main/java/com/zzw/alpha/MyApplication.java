/**
 * <p>Project: samsung358</p >
 * <p>Package: com.zzw.alpha</p >
 * <p>File: MyApplication.java</p >
 * <p>Date: 2021/8/31/17:31.</p >
 */
package com.zzw.alpha;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zzw.mvvm.base.RootApplication;


/**
 * <p>Class: com.zzw.alpha.MyApplication</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/8/31/17:31
 */
public class MyApplication extends RootApplication {

    private String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mCallbacks);
    }

    private ActivityLifecycleCallbacks mCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.d(TAG, "onActivityCreated: " + activity.getComponentName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.d(TAG, "onActivityStarted: " + activity.getComponentName());
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.d(TAG, "onActivityResumed: " + activity.getComponentName());
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.d(TAG, "onActivityPaused: " + activity.getComponentName());
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.d(TAG, "onActivityStopped: " + activity.getComponentName());
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.d(TAG, "onActivitySaveInstanceState: " + activity.getComponentName());
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.d(TAG, "onDestroy: " + activity.getComponentName());

        }
    };
}
