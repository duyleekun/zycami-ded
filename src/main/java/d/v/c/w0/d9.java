/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.d7.v$b;

public abstract class d9
extends ViewDataBinding {
    public final LinearLayout a;
    public final TextView b;
    public final View c;
    public v.b d;

    public d9(Object object, View view, int n10, LinearLayout linearLayout, TextView textView, View view2) {
        super(object, view, n10);
        this.a = linearLayout;
        this.b = textView;
        this.c = view2;
    }

    public static d9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d9.t(view, dataBindingComponent);
    }

    public static d9 t(View view, Object object) {
        return (d9)ViewDataBinding.bind(object, view, 2131558602);
    }

    public static d9 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d9.y(layoutInflater, dataBindingComponent);
    }

    public static d9 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d9.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d9)ViewDataBinding.inflateInternal(layoutInflater, 2131558602, viewGroup, bl2, object);
    }

    public static d9 y(LayoutInflater layoutInflater, Object object) {
        return (d9)ViewDataBinding.inflateInternal(layoutInflater, 2131558602, null, false, object);
    }

    public v.b u() {
        return this.d;
    }

    public abstract void z(v.b var1);
}

