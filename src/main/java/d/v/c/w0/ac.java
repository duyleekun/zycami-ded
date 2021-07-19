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

public abstract class ac
extends ViewDataBinding {
    public final View a;

    public ac(Object object, View view, int n10, View view2) {
        super(object, view, n10);
        this.a = view2;
    }

    public static ac s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ac.t(view, dataBindingComponent);
    }

    public static ac t(View view, Object object) {
        return (ac)ViewDataBinding.bind(object, view, 2131558644);
    }

    public static ac u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ac.x(layoutInflater, dataBindingComponent);
    }

    public static ac v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ac.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ac w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ac)ViewDataBinding.inflateInternal(layoutInflater, 2131558644, viewGroup, bl2, object);
    }

    public static ac x(LayoutInflater layoutInflater, Object object) {
        return (ac)ViewDataBinding.inflateInternal(layoutInflater, 2131558644, null, false, object);
    }
}

