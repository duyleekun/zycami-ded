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

public abstract class yb
extends ViewDataBinding {
    public final View a;

    public yb(Object object, View view, int n10, View view2) {
        super(object, view, n10);
        this.a = view2;
    }

    public static yb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yb.t(view, dataBindingComponent);
    }

    public static yb t(View view, Object object) {
        return (yb)ViewDataBinding.bind(object, view, 2131558643);
    }

    public static yb u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yb.x(layoutInflater, dataBindingComponent);
    }

    public static yb v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yb.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yb)ViewDataBinding.inflateInternal(layoutInflater, 2131558643, viewGroup, bl2, object);
    }

    public static yb x(LayoutInflater layoutInflater, Object object) {
        return (yb)ViewDataBinding.inflateInternal(layoutInflater, 2131558643, null, false, object);
    }
}

