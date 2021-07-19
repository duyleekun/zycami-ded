/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import d.v.a.i.b.e;

public abstract class s
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public e c;
    public boolean d;

    public s(Object object, View view, int n10, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
    }

    public static s s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return s.t(view, dataBindingComponent);
    }

    public static s t(View view, Object object) {
        int n10 = R$layout.me_country_layout_item;
        return (s)ViewDataBinding.bind(object, view, n10);
    }

    public static s w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return s.z(layoutInflater, dataBindingComponent);
    }

    public static s x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return s.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static s y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_country_layout_item;
        return (s)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static s z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_country_layout_item;
        return (s)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(e var1);

    public abstract void B(boolean var1);

    public e u() {
        return this.c;
    }

    public boolean v() {
        return this.d;
    }
}

