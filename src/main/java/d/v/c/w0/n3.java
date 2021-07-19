/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.n1.a$b;
import d.v.c.s0.a7.n1.b;

public abstract class n3
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public a.b f;
    public b g;

    public n3(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = view2;
    }

    public static n3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n3.t(view, dataBindingComponent);
    }

    public static n3 t(View view, Object object) {
        return (n3)ViewDataBinding.bind(object, view, 2131558518);
    }

    public static n3 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n3.z(layoutInflater, dataBindingComponent);
    }

    public static n3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n3.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n3 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n3)ViewDataBinding.inflateInternal(layoutInflater, 2131558518, viewGroup, bl2, object);
    }

    public static n3 z(LayoutInflater layoutInflater, Object object) {
        return (n3)ViewDataBinding.inflateInternal(layoutInflater, 2131558518, null, false, object);
    }

    public abstract void A(a.b var1);

    public abstract void B(b var1);

    public a.b u() {
        return this.f;
    }

    public b v() {
        return this.g;
    }
}

