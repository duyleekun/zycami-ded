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
import d.v.c.x0.c.c.f;

public abstract class sc
extends ViewDataBinding {
    public Integer a;
    public Integer b;
    public f c;

    public sc(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static sc A(LayoutInflater layoutInflater, Object object) {
        return (sc)ViewDataBinding.inflateInternal(layoutInflater, 2131558655, null, false, object);
    }

    public static sc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sc.t(view, dataBindingComponent);
    }

    public static sc t(View view, Object object) {
        return (sc)ViewDataBinding.bind(object, view, 2131558655);
    }

    public static sc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sc.A(layoutInflater, dataBindingComponent);
    }

    public static sc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sc)ViewDataBinding.inflateInternal(layoutInflater, 2131558655, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(f var1);

    public abstract void D(Integer var1);

    public Integer u() {
        return this.a;
    }

    public f v() {
        return this.c;
    }

    public Integer w() {
        return this.b;
    }
}

