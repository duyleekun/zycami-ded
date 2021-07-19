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

public abstract class z3
extends ViewDataBinding {
    public final ProgressBar a;
    public final TextView b;

    public z3(Object object, View view, int n10, ProgressBar progressBar, TextView textView) {
        super(object, view, n10);
        this.a = progressBar;
        this.b = textView;
    }

    public static z3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z3.t(view, dataBindingComponent);
    }

    public static z3 t(View view, Object object) {
        return (z3)ViewDataBinding.bind(object, view, 2131558524);
    }

    public static z3 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z3.x(layoutInflater, dataBindingComponent);
    }

    public static z3 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z3.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z3)ViewDataBinding.inflateInternal(layoutInflater, 2131558524, viewGroup, bl2, object);
    }

    public static z3 x(LayoutInflater layoutInflater, Object object) {
        return (z3)ViewDataBinding.inflateInternal(layoutInflater, 2131558524, null, false, object);
    }
}

