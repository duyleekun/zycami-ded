/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.j1;

public abstract class p3
extends ViewDataBinding {
    public final ProgressBar a;
    public final TextView b;
    public final TextView c;
    public j1 d;

    public p3(Object object, View view, int n10, ProgressBar progressBar, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = progressBar;
        this.b = textView;
        this.c = textView2;
    }

    public static p3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p3.t(view, dataBindingComponent);
    }

    public static p3 t(View view, Object object) {
        return (p3)ViewDataBinding.bind(object, view, 2131558519);
    }

    public static p3 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p3.y(layoutInflater, dataBindingComponent);
    }

    public static p3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p3.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p3)ViewDataBinding.inflateInternal(layoutInflater, 2131558519, viewGroup, bl2, object);
    }

    public static p3 y(LayoutInflater layoutInflater, Object object) {
        return (p3)ViewDataBinding.inflateInternal(layoutInflater, 2131558519, null, false, object);
    }

    public j1 u() {
        return this.d;
    }

    public abstract void z(j1 var1);
}

