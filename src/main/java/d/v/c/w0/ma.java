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
import d.v.c.y0.b.u.b;

public abstract class ma
extends ViewDataBinding {
    public final TextView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public b f;

    public ma(Object object, View view, int n10, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = textView;
        this.b = imageView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static ma s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ma.t(view, dataBindingComponent);
    }

    public static ma t(View view, Object object) {
        return (ma)ViewDataBinding.bind(object, view, 2131558624);
    }

    public static ma v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ma.y(layoutInflater, dataBindingComponent);
    }

    public static ma w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ma.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ma x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ma)ViewDataBinding.inflateInternal(layoutInflater, 2131558624, viewGroup, bl2, object);
    }

    public static ma y(LayoutInflater layoutInflater, Object object) {
        return (ma)ViewDataBinding.inflateInternal(layoutInflater, 2131558624, null, false, object);
    }

    public b u() {
        return this.f;
    }

    public abstract void z(b var1);
}

