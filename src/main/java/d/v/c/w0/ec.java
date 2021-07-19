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
import d.v.c.s1.t;
import d.v.c.s1.u;

public abstract class ec
extends ViewDataBinding {
    public Integer a;
    public t b;
    public u c;

    public ec(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static ec A(LayoutInflater layoutInflater, Object object) {
        return (ec)ViewDataBinding.inflateInternal(layoutInflater, 2131558646, null, false, object);
    }

    public static ec s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ec.t(view, dataBindingComponent);
    }

    public static ec t(View view, Object object) {
        return (ec)ViewDataBinding.bind(object, view, 2131558646);
    }

    public static ec x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ec.A(layoutInflater, dataBindingComponent);
    }

    public static ec y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ec.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ec z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ec)ViewDataBinding.inflateInternal(layoutInflater, 2131558646, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(t var1);

    public abstract void D(u var1);

    public Integer u() {
        return this.a;
    }

    public t v() {
        return this.b;
    }

    public u w() {
        return this.c;
    }
}

