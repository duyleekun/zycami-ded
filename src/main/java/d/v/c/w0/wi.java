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
import d.v.c.q0.f.a;

public abstract class wi
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public a d;

    public wi(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static wi s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wi.t(view, dataBindingComponent);
    }

    public static wi t(View view, Object object) {
        return (wi)ViewDataBinding.bind(object, view, 2131558817);
    }

    public static wi v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wi.y(layoutInflater, dataBindingComponent);
    }

    public static wi w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wi.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wi x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wi)ViewDataBinding.inflateInternal(layoutInflater, 2131558817, viewGroup, bl2, object);
    }

    public static wi y(LayoutInflater layoutInflater, Object object) {
        return (wi)ViewDataBinding.inflateInternal(layoutInflater, 2131558817, null, false, object);
    }

    public a u() {
        return this.d;
    }

    public abstract void z(a var1);
}

