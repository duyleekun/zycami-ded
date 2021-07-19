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

public abstract class wa
extends ViewDataBinding {
    public wa(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static wa s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wa.t(view, dataBindingComponent);
    }

    public static wa t(View view, Object object) {
        return (wa)ViewDataBinding.bind(object, view, 2131558629);
    }

    public static wa u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wa.x(layoutInflater, dataBindingComponent);
    }

    public static wa v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wa.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wa w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wa)ViewDataBinding.inflateInternal(layoutInflater, 2131558629, viewGroup, bl2, object);
    }

    public static wa x(LayoutInflater layoutInflater, Object object) {
        return (wa)ViewDataBinding.inflateInternal(layoutInflater, 2131558629, null, false, object);
    }
}

