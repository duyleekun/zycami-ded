/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.n1.h2$b;

public abstract class h6
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public Boolean f;
    public h2$b g;

    public h6(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static h6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h6.t(view, dataBindingComponent);
    }

    public static h6 t(View view, Object object) {
        return (h6)ViewDataBinding.bind(object, view, 2131558565);
    }

    public static h6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h6.z(layoutInflater, dataBindingComponent);
    }

    public static h6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h6)ViewDataBinding.inflateInternal(layoutInflater, 2131558565, viewGroup, bl2, object);
    }

    public static h6 z(LayoutInflater layoutInflater, Object object) {
        return (h6)ViewDataBinding.inflateInternal(layoutInflater, 2131558565, null, false, object);
    }

    public abstract void A(h2$b var1);

    public abstract void B(Boolean var1);

    public h2$b u() {
        return this.g;
    }

    public Boolean v() {
        return this.f;
    }
}

