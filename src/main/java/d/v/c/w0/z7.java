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

public abstract class z7
extends ViewDataBinding {
    public z7(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static z7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z7.t(view, dataBindingComponent);
    }

    public static z7 t(View view, Object object) {
        return (z7)ViewDataBinding.bind(object, view, 2131558587);
    }

    public static z7 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z7.x(layoutInflater, dataBindingComponent);
    }

    public static z7 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z7.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z7 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z7)ViewDataBinding.inflateInternal(layoutInflater, 2131558587, viewGroup, bl2, object);
    }

    public static z7 x(LayoutInflater layoutInflater, Object object) {
        return (z7)ViewDataBinding.inflateInternal(layoutInflater, 2131558587, null, false, object);
    }
}

