/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package com.zhiyun.account;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.DataBinderMapperImpl$a;
import com.zhiyun.account.DataBinderMapperImpl$b;
import com.zhiyun.account.R$layout;
import d.v.a.g.b;
import d.v.a.g.b0;
import d.v.a.g.d;
import d.v.a.g.d0;
import d.v.a.g.f;
import d.v.a.g.f0;
import d.v.a.g.h;
import d.v.a.g.h0;
import d.v.a.g.j;
import d.v.a.g.j0;
import d.v.a.g.l;
import d.v.a.g.l0;
import d.v.a.g.n;
import d.v.a.g.n0;
import d.v.a.g.p;
import d.v.a.g.r;
import d.v.a.g.t;
import d.v.a.g.v;
import d.v.a.g.x;
import d.v.a.g.z;
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
    private static final int f = 6;
    private static final int g = 7;
    private static final int h = 8;
    private static final int i = 9;
    private static final int j = 10;
    private static final int k = 11;
    private static final int l = 12;
    private static final int m = 13;
    private static final int n = 14;
    private static final int o = 15;
    private static final int p = 16;
    private static final int q = 17;
    private static final int r = 18;
    private static final int s = 19;
    private static final int t = 20;
    private static final SparseIntArray u;

    static {
        SparseIntArray sparseIntArray;
        int n10 = 20;
        u = sparseIntArray = new SparseIntArray(n10);
        int n11 = R$layout.base_status_view;
        sparseIntArray.put(n11, 1);
        n11 = R$layout.me_account_get_code_frag;
        sparseIntArray.put(n11, 2);
        n11 = R$layout.me_account_login_frag;
        sparseIntArray.put(n11, 3);
        n11 = R$layout.me_account_login_quick_frag;
        sparseIntArray.put(n11, 4);
        n11 = R$layout.me_account_main_frag;
        sparseIntArray.put(n11, 5);
        n11 = R$layout.me_account_self_login_dialog;
        sparseIntArray.put(n11, 6);
        n11 = R$layout.me_acoount_set_pass_frag;
        sparseIntArray.put(n11, 7);
        n11 = R$layout.me_country_act;
        sparseIntArray.put(n11, 8);
        n11 = R$layout.me_country_head_item;
        sparseIntArray.put(n11, 9);
        n11 = R$layout.me_country_layout_item;
        sparseIntArray.put(n11, 10);
        n11 = R$layout.me_get_code_view;
        sparseIntArray.put(n11, 11);
        n11 = R$layout.me_name_view;
        sparseIntArray.put(n11, 12);
        n11 = R$layout.me_pass_view;
        sparseIntArray.put(n11, 13);
        n11 = R$layout.set_private_bind_frag;
        sparseIntArray.put(n11, 14);
        n11 = R$layout.set_private_bind_success_frag;
        sparseIntArray.put(n11, 15);
        n11 = R$layout.set_private_bind_third_frag;
        sparseIntArray.put(n11, 16);
        n11 = R$layout.set_private_choose_modify_pass;
        sparseIntArray.put(n11, 17);
        n11 = R$layout.set_private_get_code_frag;
        sparseIntArray.put(n11, 18);
        n11 = R$layout.set_private_set_new_pass_frag;
        sparseIntArray.put(n11, 19);
        n11 = R$layout.simple_webview_act;
        sparseIntArray.put(n11, n10);
    }

    public List collectDependencies() {
        ArrayList<androidx.databinding.library.baseAdapters.DataBinderMapperImpl> arrayList = new ArrayList<androidx.databinding.library.baseAdapters.DataBinderMapperImpl>(4);
        DataBinderMapper dataBinderMapper = new androidx.databinding.library.baseAdapters.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        dataBinderMapper = new com.zhiyun.component.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        dataBinderMapper = new com.zhiyun.ui.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        dataBinderMapper = new skin.support.appcompat.DataBinderMapperImpl();
        arrayList.add((androidx.databinding.library.baseAdapters.DataBinderMapperImpl)dataBinderMapper);
        return arrayList;
    }

    public String convertBrIdToString(int n10) {
        return (String)DataBinderMapperImpl$a.a.get(n10);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent object, View object2, int n10) {
        block42: {
            block43: {
                Object object3 = u;
                if ((n10 = object3.get(n10)) <= 0) break block42;
                object3 = object2.getTag();
                if (object3 == null) break block43;
                switch (n10) {
                    default: {
                        break block42;
                    }
                    case 20: {
                        Object object4 = "layout/simple_webview_act_0";
                        n10 = (int)(((String)object4).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object4 = new n0((DataBindingComponent)object, (View)object2);
                            return object4;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for simple_webview_act is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 19: {
                        Object object5 = "layout/set_private_set_new_pass_frag_0";
                        n10 = (int)(((String)object5).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object5 = new l0((DataBindingComponent)object, (View)object2);
                            return object5;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_set_new_pass_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 18: {
                        Object object6 = "layout/set_private_get_code_frag_0";
                        n10 = (int)(((String)object6).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object6 = new j0((DataBindingComponent)object, (View)object2);
                            return object6;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_get_code_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 17: {
                        Object object7 = "layout/set_private_choose_modify_pass_0";
                        n10 = (int)(((String)object7).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object7 = new h0((DataBindingComponent)object, (View)object2);
                            return object7;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_choose_modify_pass is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 16: {
                        Object object8 = "layout/set_private_bind_third_frag_0";
                        n10 = (int)(((String)object8).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object8 = new f0((DataBindingComponent)object, (View)object2);
                            return object8;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_bind_third_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 15: {
                        Object object9 = "layout/set_private_bind_success_frag_0";
                        n10 = (int)(((String)object9).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object9 = new d0((DataBindingComponent)object, (View)object2);
                            return object9;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_bind_success_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 14: {
                        Object object10 = "layout/set_private_bind_frag_0";
                        n10 = (int)(((String)object10).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object10 = new b0((DataBindingComponent)object, (View)object2);
                            return object10;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for set_private_bind_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 13: {
                        Object object11 = "layout/me_pass_view_0";
                        n10 = (int)(((String)object11).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object11 = new z((DataBindingComponent)object, (View)object2);
                            return object11;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_pass_view is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 12: {
                        Object object12 = "layout/me_name_view_0";
                        n10 = (int)(((String)object12).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object12 = new x((DataBindingComponent)object, (View)object2);
                            return object12;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_name_view is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 11: {
                        Object object13 = "layout/me_get_code_view_0";
                        n10 = (int)(((String)object13).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object13 = new v((DataBindingComponent)object, (View)object2);
                            return object13;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_get_code_view is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 10: {
                        Object object14 = "layout/me_country_layout_item_0";
                        n10 = (int)(((String)object14).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object14 = new t((DataBindingComponent)object, (View)object2);
                            return object14;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_country_layout_item is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 9: {
                        Object object15 = "layout/me_country_head_item_0";
                        n10 = (int)(((String)object15).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object15 = new r((DataBindingComponent)object, (View)object2);
                            return object15;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_country_head_item is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 8: {
                        Object object16 = "layout/me_country_act_0";
                        n10 = (int)(((String)object16).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object16 = new p((DataBindingComponent)object, (View)object2);
                            return object16;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_country_act is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 7: {
                        Object object17 = "layout/me_acoount_set_pass_frag_0";
                        n10 = (int)(((String)object17).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object17 = new n((DataBindingComponent)object, (View)object2);
                            return object17;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_acoount_set_pass_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 6: {
                        Object object18 = "layout/me_account_self_login_dialog_0";
                        n10 = (int)(((String)object18).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object18 = new l((DataBindingComponent)object, (View)object2);
                            return object18;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_account_self_login_dialog is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 5: {
                        Object object19 = "layout/me_account_main_frag_0";
                        n10 = (int)(((String)object19).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object19 = new j((DataBindingComponent)object, (View)object2);
                            return object19;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_account_main_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 4: {
                        Object object20 = "layout/me_account_login_quick_frag_0";
                        n10 = (int)(((String)object20).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object20 = new h((DataBindingComponent)object, (View)object2);
                            return object20;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_account_login_quick_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 3: {
                        Object object21 = "layout/me_account_login_frag_0";
                        n10 = (int)(((String)object21).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object21 = new f((DataBindingComponent)object, (View)object2);
                            return object21;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_account_login_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 2: {
                        Object object22 = "layout/me_account_get_code_frag_0";
                        n10 = (int)(((String)object22).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object22 = new d((DataBindingComponent)object, (View)object2);
                            return object22;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for me_account_get_code_frag is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    case 1: {
                        Object object23 = "layout/base_status_view_0";
                        n10 = (int)(((String)object23).equals(object3) ? 1 : 0);
                        if (n10 != 0) {
                            object23 = new b((DataBindingComponent)object, (View)object2);
                            return object23;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("The tag for base_status_view is invalid. Received: ");
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                }
            }
            object = new RuntimeException("view must have a tag");
            throw object;
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent object, View[] object2, int n10) {
        SparseIntArray sparseIntArray;
        int n11;
        object = null;
        if (object2 != null && (n11 = ((View[])object2).length) != 0 && (n10 = (sparseIntArray = u).get(n10)) > 0) {
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

