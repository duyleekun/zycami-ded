/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package com.zhiyun.live;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.live.DataBinderMapperImpl$a;
import com.zhiyun.live.DataBinderMapperImpl$b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl
extends DataBinderMapper {
    private static final SparseIntArray a;

    static {
        SparseIntArray sparseIntArray;
        a = sparseIntArray = new SparseIntArray(0);
    }

    public List collectDependencies() {
        ArrayList<androidx.databinding.library.baseAdapters.DataBinderMapperImpl> arrayList = new ArrayList<androidx.databinding.library.baseAdapters.DataBinderMapperImpl>(3);
        DataBinderMapper dataBinderMapper = new androidx.databinding.library.baseAdapters.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        dataBinderMapper = new com.zhiyun.component.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        dataBinderMapper = new skin.support.appcompat.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        return arrayList;
    }

    public String convertBrIdToString(int n10) {
        return (String)DataBinderMapperImpl$a.a.get(n10);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent object, View view, int n10) {
        object = a;
        int n11 = object.get(n10);
        if (n11 > 0 && (object = view.getTag()) == null) {
            object = new RuntimeException("view must have a tag");
            throw object;
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent object, View[] object2, int n10) {
        SparseIntArray sparseIntArray;
        int n11;
        object = null;
        if (object2 != null && (n11 = ((View[])object2).length) != 0 && (n10 = (sparseIntArray = a).get(n10)) > 0) {
            n10 = 0;
            if ((object2 = object2[0].getTag()) == null) {
                object = new RuntimeException("view must have a tag");
                throw object;
            }
        }
        return null;
    }

    public int getLayoutId(String object) {
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        HashMap hashMap = DataBinderMapperImpl$b.a;
        if ((object = (Integer)hashMap.get(object)) != null) {
            n10 = (Integer)object;
        }
        return n10;
    }
}

