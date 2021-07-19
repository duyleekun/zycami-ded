/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.d7.v$b;
import d.v.g0.o;

public abstract class eb
extends ViewDataBinding {
    public final TextView a;
    public o b;
    public Integer c;
    public v$b d;

    public eb(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static eb A(LayoutInflater layoutInflater, Object object) {
        return (eb)ViewDataBinding.inflateInternal(layoutInflater, 2131558633, null, false, object);
    }

    public static eb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eb.t(view, dataBindingComponent);
    }

    public static eb t(View view, Object object) {
        return (eb)ViewDataBinding.bind(object, view, 2131558633);
    }

    public static eb x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eb.A(layoutInflater, dataBindingComponent);
    }

    public static eb y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eb.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static eb z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (eb)ViewDataBinding.inflateInternal(layoutInflater, 2131558633, viewGroup, bl2, object);
    }

    public abstract void B(v$b var1);

    public abstract void C(o var1);

    public abstract void D(Integer var1);

    public v$b u() {
        return this.d;
    }

    public o v() {
        return this.b;
    }

    public Integer w() {
        return this.c;
    }
}

