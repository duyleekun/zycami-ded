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
import d.v.c.b1.t.f$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.w0.sf;

public abstract class d5
extends ViewDataBinding {
    public final sf a;
    public i2 b;
    public g c;
    public f$a d;

    public d5(Object object, View view, int n10, sf sf2) {
        super(object, view, n10);
        this.a = sf2;
    }

    public static d5 A(LayoutInflater layoutInflater, Object object) {
        return (d5)ViewDataBinding.inflateInternal(layoutInflater, 2131558539, null, false, object);
    }

    public static d5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d5.t(view, dataBindingComponent);
    }

    public static d5 t(View view, Object object) {
        return (d5)ViewDataBinding.bind(object, view, 2131558539);
    }

    public static d5 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d5.A(layoutInflater, dataBindingComponent);
    }

    public static d5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d5.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d5 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d5)ViewDataBinding.inflateInternal(layoutInflater, 2131558539, viewGroup, bl2, object);
    }

    public abstract void B(f$a var1);

    public abstract void C(i2 var1);

    public abstract void D(g var1);

    public f$a u() {
        return this.d;
    }

    public i2 v() {
        return this.b;
    }

    public g w() {
        return this.c;
    }
}

