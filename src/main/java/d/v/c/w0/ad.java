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

public abstract class ad
extends ViewDataBinding {
    public final View a;

    public ad(Object object, View view, int n10, View view2) {
        super(object, view, n10);
        this.a = view2;
    }

    public static ad s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ad.t(view, dataBindingComponent);
    }

    public static ad t(View view, Object object) {
        return (ad)ViewDataBinding.bind(object, view, 2131558659);
    }

    public static ad u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ad.x(layoutInflater, dataBindingComponent);
    }

    public static ad v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ad.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ad w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ad)ViewDataBinding.inflateInternal(layoutInflater, 2131558659, viewGroup, bl2, object);
    }

    public static ad x(LayoutInflater layoutInflater, Object object) {
        return (ad)ViewDataBinding.inflateInternal(layoutInflater, 2131558659, null, false, object);
    }
}

