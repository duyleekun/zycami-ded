/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.d7.z;

public abstract class kb
extends ViewDataBinding {
    public final ImageView a;
    public final RelativeLayout b;
    public final TextView c;
    public z d;

    public kb(Object object, View view, int n10, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = relativeLayout;
        this.c = textView;
    }

    public static kb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kb.t(view, dataBindingComponent);
    }

    public static kb t(View view, Object object) {
        return (kb)ViewDataBinding.bind(object, view, 2131558636);
    }

    public static kb v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kb.y(layoutInflater, dataBindingComponent);
    }

    public static kb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kb.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static kb x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kb)ViewDataBinding.inflateInternal(layoutInflater, 2131558636, viewGroup, bl2, object);
    }

    public static kb y(LayoutInflater layoutInflater, Object object) {
        return (kb)ViewDataBinding.inflateInternal(layoutInflater, 2131558636, null, false, object);
    }

    public z u() {
        return this.d;
    }

    public abstract void z(z var1);
}

