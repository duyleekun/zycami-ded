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
import d.v.c.s0.a7.z0$a;

public abstract class z0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public z0.a e;

    public z0(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static z0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z0.t(view, dataBindingComponent);
    }

    public static z0 t(View view, Object object) {
        return (z0)ViewDataBinding.bind(object, view, 2131558466);
    }

    public static z0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z0.y(layoutInflater, dataBindingComponent);
    }

    public static z0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z0)ViewDataBinding.inflateInternal(layoutInflater, 2131558466, viewGroup, bl2, object);
    }

    public static z0 y(LayoutInflater layoutInflater, Object object) {
        return (z0)ViewDataBinding.inflateInternal(layoutInflater, 2131558466, null, false, object);
    }

    public z0.a u() {
        return this.e;
    }

    public abstract void z(z0.a var1);
}

