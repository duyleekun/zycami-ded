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

public abstract class ua
extends ViewDataBinding {
    public ua(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static ua s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ua.t(view, dataBindingComponent);
    }

    public static ua t(View view, Object object) {
        return (ua)ViewDataBinding.bind(object, view, 2131558628);
    }

    public static ua u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ua.x(layoutInflater, dataBindingComponent);
    }

    public static ua v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ua.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ua w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ua)ViewDataBinding.inflateInternal(layoutInflater, 2131558628, viewGroup, bl2, object);
    }

    public static ua x(LayoutInflater layoutInflater, Object object) {
        return (ua)ViewDataBinding.inflateInternal(layoutInflater, 2131558628, null, false, object);
    }
}

