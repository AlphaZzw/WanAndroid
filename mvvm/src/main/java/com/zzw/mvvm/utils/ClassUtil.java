/**
 * <p>Project: WanAndroid</p >
 * <p>Package: com.zzw.mvvm.utils</p >
 * <p>File: ClassUtil.java</p >
 * <p>Date: 2021/9/8/13:37.</p >
 */
package com.zzw.mvvm.utils;

import androidx.lifecycle.AndroidViewModel;

import com.zzw.mvvm.base.NoViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>Class: com.zzw.mvvm.utils.ClassUtil</p >
 * <p>Description:</p >
 * <pre>
 *
 * </pre>
 *
 * @author zhuzhengwei
 * @date 2021/9/8/13:37
 */
public class ClassUtil {
    /**
     * 获取泛型ViewModel的class对象
     */
    public static <T> Class<T> getViewModel(Object obj) {
        Class<?> currentClass = obj.getClass();
        Class<T> tClass = getGenericClass(currentClass, AndroidViewModel.class);
        if (tClass == null || tClass == AndroidViewModel.class || tClass == NoViewModel.class) {
            return null;
        }
        return tClass;
    }

    private static <T> Class<T> getGenericClass(Class<?> klass, Class<?> filterClass) {
        Type type = klass.getGenericSuperclass();
        if (type == null || !(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        for (Type t : types) {
            Class<T> tClass = (Class<T>) t;
            if (filterClass.isAssignableFrom(tClass)) {
                return tClass;
            }
        }
        return null;
    }
}
