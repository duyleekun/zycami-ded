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
import d.v.c.z0.h$a;

public abstract class v
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public h$a d;

    public v(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static v s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v.t(view, dataBindingComponent);
    }

    public static v t(View view, Object object) {
        return (v)ViewDataBinding.bind(object, view, 2131558447);
    }

    public static v v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v.y(layoutInflater, dataBindingComponent);
    }

    public static v w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v)ViewDataBinding.inflateInternal(layoutInflater, 2131558447, viewGroup, bl2, object);
    }

    public static v y(LayoutInflater layoutInflater, Object object) {
        return (v)ViewDataBinding.inflateInternal(layoutInflater, 2131558447, null, false, object);
    }

    public h$a u() {
        return this.d;
    }

    public abstract void z(h$a var1);
}

