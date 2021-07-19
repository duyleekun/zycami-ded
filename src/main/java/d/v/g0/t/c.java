/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;
import d.v.g0.i$a;

public abstract class c
extends ViewDataBinding {
    public final LinearLayout a;
    public final TextView b;
    public i$a c;
    public Boolean d;

    public c(Object object, View view, int n10, LinearLayout linearLayout, TextView textView) {
        super(object, view, n10);
        this.a = linearLayout;
        this.b = textView;
    }

    public static c s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.c.t(view, dataBindingComponent);
    }

    public static c t(View view, Object object) {
        int n10 = R$layout.zyui_frag_bottom_list_dialog;
        return (c)ViewDataBinding.bind(object, view, n10);
    }

    public static c w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.c.z(layoutInflater, dataBindingComponent);
    }

    public static c x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.c.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static c y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.zyui_frag_bottom_list_dialog;
        return (c)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static c z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.zyui_frag_bottom_list_dialog;
        return (c)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(i$a var1);

    public abstract void B(Boolean var1);

    public i$a u() {
        return this.c;
    }

    public Boolean v() {
        return this.d;
    }
}

