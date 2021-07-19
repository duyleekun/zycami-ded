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
import androidx.recyclerview.widget.RecyclerView;

public abstract class od
extends ViewDataBinding {
    public final RecyclerView a;

    public od(Object object, View view, int n10, RecyclerView recyclerView) {
        super(object, view, n10);
        this.a = recyclerView;
    }

    public static od s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return od.t(view, dataBindingComponent);
    }

    public static od t(View view, Object object) {
        return (od)ViewDataBinding.bind(object, view, 2131558672);
    }

    public static od u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return od.x(layoutInflater, dataBindingComponent);
    }

    public static od v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return od.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static od w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (od)ViewDataBinding.inflateInternal(layoutInflater, 2131558672, viewGroup, bl2, object);
    }

    public static od x(LayoutInflater layoutInflater, Object object) {
        return (od)ViewDataBinding.inflateInternal(layoutInflater, 2131558672, null, false, object);
    }
}

