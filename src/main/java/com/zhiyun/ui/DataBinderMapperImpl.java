/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package com.zhiyun.ui;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.DataBinderMapperImpl$a;
import com.zhiyun.ui.DataBinderMapperImpl$b;
import com.zhiyun.ui.R$layout;
import d.v.g0.t.b;
import d.v.g0.t.d;
import d.v.g0.t.f;
import d.v.g0.t.h;
import d.v.g0.t.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl
extends DataBinderMapper {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final SparseIntArray f;

    static {
        SparseIntArray sparseIntArray;
        int n10 = 5;
        f = sparseIntArray = new SparseIntArray(n10);
        int n11 = R$layout.zyui_appbars;
        sparseIntArray.put(n11, 1);
        n11 = R$layout.zyui_frag_bottom_list_dialog;
        sparseIntArray.put(n11, 2);
        n11 = R$layout.zyui_frag_confirm;
        sparseIntArray.put(n11, 3);
        n11 = R$layout.zyui_item_bottom_list;
        sparseIntArray.put(n11, 4);
        n11 = R$layout.zyui_pop_guide_layout;
        sparseIntArray.put(n11, n10);
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ViewDataBinding getDataBinder(DataBindingComponent object, View object2, int n10) {
        SparseIntArray sparseIntArray = f;
        if ((n10 = sparseIntArray.get(n10)) <= 0) return null;
        Object object3 = object2.getTag();
        if (object3 != null) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) return null;
                            String string2 = "layout/zyui_pop_guide_layout_0";
                            n10 = (int)(string2.equals(object3) ? 1 : 0);
                            if (n10 != 0) {
                                return new j((DataBindingComponent)object, (View)object2);
                            }
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("The tag for zyui_pop_guide_layout is invalid. Received: ");
                            ((StringBuilder)object2).append(object3);
                            object2 = ((StringBuilder)object2).toString();
                            object = new IllegalArgumentException((String)object2);
                            throw object;
                        }
                        String string3 = "layout/zyui_item_bottom_list_0";
                        n10 = (int)(string3.equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            return new h((DataBindingComponent)object, (View)object2);
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for zyui_item_bottom_list is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    String string4 = "layout/zyui_frag_confirm_0";
                    n10 = (int)(string4.equals(object3) ? 1 : 0);
                    if (n10 != 0) {
                        return new f((DataBindingComponent)object, (View)object2);
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("The tag for zyui_frag_confirm is invalid. Received: ");
                    ((StringBuilder)object2).append(object3);
                    object2 = ((StringBuilder)object2).toString();
                    object = new IllegalArgumentException((String)object2);
                    throw object;
                }
                String string5 = "layout/zyui_frag_bottom_list_dialog_0";
                n10 = (int)(string5.equals(object3) ? 1 : 0);
                if (n10 != 0) {
                    return new d((DataBindingComponent)object, (View)object2);
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("The tag for zyui_frag_bottom_list_dialog is invalid. Received: ");
                ((StringBuilder)object2).append(object3);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            String string6 = "layout/zyui_appbars_0";
            n10 = (int)(string6.equals(object3) ? 1 : 0);
            if (n10 != 0) {
                return new b((DataBindingComponent)object, (View)object2);
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The tag for zyui_appbars is invalid. Received: ");
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object = new RuntimeException("view must have a tag");
        throw object;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent object, View[] object2, int n10) {
        SparseIntArray sparseIntArray;
        int n11;
        object = null;
        if (object2 != null && (n11 = ((View[])object2).length) != 0 && (n10 = (sparseIntArray = f).get(n10)) > 0) {
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

