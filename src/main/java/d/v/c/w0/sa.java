/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.b1.r;
import d.v.c.b1.s;

public abstract class sa
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final View e;
    public r f;
    public Integer g;
    public s h;

    public sa(Object object, View view, int n10, TextView textView, TextView textView2, ImageView imageView, TextView textView3, View view2) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = imageView;
        this.d = textView3;
        this.e = view2;
    }

    public static sa A(LayoutInflater layoutInflater, Object object) {
        return (sa)ViewDataBinding.inflateInternal(layoutInflater, 2131558627, null, false, object);
    }

    public static sa s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sa.t(view, dataBindingComponent);
    }

    public static sa t(View view, Object object) {
        return (sa)ViewDataBinding.bind(object, view, 2131558627);
    }

    public static sa x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sa.A(layoutInflater, dataBindingComponent);
    }

    public static sa y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sa.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sa z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sa)ViewDataBinding.inflateInternal(layoutInflater, 2131558627, viewGroup, bl2, object);
    }

    public abstract void B(r var1);

    public abstract void C(Integer var1);

    public abstract void D(s var1);

    public r u() {
        return this.f;
    }

    public Integer v() {
        return this.g;
    }

    public s w() {
        return this.h;
    }
}

