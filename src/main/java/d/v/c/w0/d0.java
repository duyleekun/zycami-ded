/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class d0
extends ViewDataBinding {
    public final View a;

    public d0(Object object, View view, int n10, View view2) {
        super(object, view, n10);
        this.a = view2;
    }

    public static d0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d0.t(view, dataBindingComponent);
    }

    public static d0 t(View view, Object object) {
        return (d0)ViewDataBinding.bind(object, view, 2131558452);
    }

    public static d0 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d0.x(layoutInflater, dataBindingComponent);
    }

    public static d0 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d0.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d0)ViewDataBinding.inflateInternal(layoutInflater, 2131558452, viewGroup, bl2, object);
    }

    public static d0 x(LayoutInflater layoutInflater, Object object) {
        return (d0)ViewDataBinding.inflateInternal(layoutInflater, 2131558452, null, false, object);
    }
}

