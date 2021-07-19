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

public abstract class mb
extends ViewDataBinding {
    public final TextView a;

    public mb(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static mb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mb.t(view, dataBindingComponent);
    }

    public static mb t(View view, Object object) {
        return (mb)ViewDataBinding.bind(object, view, 2131558637);
    }

    public static mb u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mb.x(layoutInflater, dataBindingComponent);
    }

    public static mb v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mb.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mb)ViewDataBinding.inflateInternal(layoutInflater, 2131558637, viewGroup, bl2, object);
    }

    public static mb x(LayoutInflater layoutInflater, Object object) {
        return (mb)ViewDataBinding.inflateInternal(layoutInflater, 2131558637, null, false, object);
    }
}

