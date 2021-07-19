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

public abstract class mc
extends ViewDataBinding {
    public mc(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static mc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mc.t(view, dataBindingComponent);
    }

    public static mc t(View view, Object object) {
        return (mc)ViewDataBinding.bind(object, view, 2131558650);
    }

    public static mc u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mc.x(layoutInflater, dataBindingComponent);
    }

    public static mc v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mc.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mc w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mc)ViewDataBinding.inflateInternal(layoutInflater, 2131558650, viewGroup, bl2, object);
    }

    public static mc x(LayoutInflater layoutInflater, Object object) {
        return (mc)ViewDataBinding.inflateInternal(layoutInflater, 2131558650, null, false, object);
    }
}

