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

public abstract class kf
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;

    public kf(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static kf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kf.t(view, dataBindingComponent);
    }

    public static kf t(View view, Object object) {
        return (kf)ViewDataBinding.bind(object, view, 2131558708);
    }

    public static kf u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kf.x(layoutInflater, dataBindingComponent);
    }

    public static kf v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kf.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static kf w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kf)ViewDataBinding.inflateInternal(layoutInflater, 2131558708, viewGroup, bl2, object);
    }

    public static kf x(LayoutInflater layoutInflater, Object object) {
        return (kf)ViewDataBinding.inflateInternal(layoutInflater, 2131558708, null, false, object);
    }
}

