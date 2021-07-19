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

public abstract class gf
extends ViewDataBinding {
    public final View a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public gf(Object object, View view, int n10, View view2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = view2;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
    }

    public static gf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gf.t(view, dataBindingComponent);
    }

    public static gf t(View view, Object object) {
        return (gf)ViewDataBinding.bind(object, view, 2131558706);
    }

    public static gf u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gf.x(layoutInflater, dataBindingComponent);
    }

    public static gf v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gf.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gf w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gf)ViewDataBinding.inflateInternal(layoutInflater, 2131558706, viewGroup, bl2, object);
    }

    public static gf x(LayoutInflater layoutInflater, Object object) {
        return (gf)ViewDataBinding.inflateInternal(layoutInflater, 2131558706, null, false, object);
    }
}

