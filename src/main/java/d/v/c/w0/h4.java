/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.i1.i2;
import d.v.c.i1.l2$a;

public abstract class h4
extends ViewDataBinding {
    public final ProgressBar a;
    public final TextView b;
    public l2$a c;
    public i2 d;

    public h4(Object object, View view, int n10, ProgressBar progressBar, TextView textView) {
        super(object, view, n10);
        this.a = progressBar;
        this.b = textView;
    }

    public static h4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h4.t(view, dataBindingComponent);
    }

    public static h4 t(View view, Object object) {
        return (h4)ViewDataBinding.bind(object, view, 2131558528);
    }

    public static h4 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h4.z(layoutInflater, dataBindingComponent);
    }

    public static h4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h4.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h4 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h4)ViewDataBinding.inflateInternal(layoutInflater, 2131558528, viewGroup, bl2, object);
    }

    public static h4 z(LayoutInflater layoutInflater, Object object) {
        return (h4)ViewDataBinding.inflateInternal(layoutInflater, 2131558528, null, false, object);
    }

    public abstract void A(l2$a var1);

    public abstract void B(i2 var1);

    public l2$a u() {
        return this.c;
    }

    public i2 v() {
        return this.d;
    }
}

