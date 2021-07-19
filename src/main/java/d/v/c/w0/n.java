/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class n
extends ViewDataBinding {
    public final FrameLayout a;

    public n(Object object, View view, int n10, FrameLayout frameLayout) {
        super(object, view, n10);
        this.a = frameLayout;
    }

    public static n s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n.t(view, dataBindingComponent);
    }

    public static n t(View view, Object object) {
        return (n)ViewDataBinding.bind(object, view, 2131558436);
    }

    public static n u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n.x(layoutInflater, dataBindingComponent);
    }

    public static n v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n)ViewDataBinding.inflateInternal(layoutInflater, 2131558436, viewGroup, bl2, object);
    }

    public static n x(LayoutInflater layoutInflater, Object object) {
        return (n)ViewDataBinding.inflateInternal(layoutInflater, 2131558436, null, false, object);
    }
}

