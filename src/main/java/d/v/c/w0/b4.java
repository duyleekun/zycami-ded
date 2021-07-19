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
import d.v.c.z0.i$b;

public abstract class b4
extends ViewDataBinding {
    public final TextView a;
    public final ProgressBar b;
    public final TextView c;
    public i$b d;

    public b4(Object object, View view, int n10, TextView textView, ProgressBar progressBar, TextView textView2) {
        super(object, view, n10);
        this.a = textView;
        this.b = progressBar;
        this.c = textView2;
    }

    public static b4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b4.t(view, dataBindingComponent);
    }

    public static b4 t(View view, Object object) {
        return (b4)ViewDataBinding.bind(object, view, 2131558525);
    }

    public static b4 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b4.y(layoutInflater, dataBindingComponent);
    }

    public static b4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b4.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b4)ViewDataBinding.inflateInternal(layoutInflater, 2131558525, viewGroup, bl2, object);
    }

    public static b4 y(LayoutInflater layoutInflater, Object object) {
        return (b4)ViewDataBinding.inflateInternal(layoutInflater, 2131558525, null, false, object);
    }

    public i$b u() {
        return this.d;
    }

    public abstract void z(i$b var1);
}

