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
import d.v.c.s0.a7.w0$a;

public abstract class l0
extends ViewDataBinding {
    public final TextView a;
    public int b;
    public String c;
    public w0.a d;

    public l0(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static l0 A(LayoutInflater layoutInflater, Object object) {
        return (l0)ViewDataBinding.inflateInternal(layoutInflater, 2131558459, null, false, object);
    }

    public static l0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l0.t(view, dataBindingComponent);
    }

    public static l0 t(View view, Object object) {
        return (l0)ViewDataBinding.bind(object, view, 2131558459);
    }

    public static l0 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l0.A(layoutInflater, dataBindingComponent);
    }

    public static l0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l0.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l0 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l0)ViewDataBinding.inflateInternal(layoutInflater, 2131558459, viewGroup, bl2, object);
    }

    public abstract void B(String var1);

    public abstract void C(w0.a var1);

    public abstract void D(int var1);

    public String u() {
        return this.c;
    }

    public w0.a v() {
        return this.d;
    }

    public int w() {
        return this.b;
    }
}

