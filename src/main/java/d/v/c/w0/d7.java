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

public abstract class d7
extends ViewDataBinding {
    public final RecyclerView a;

    public d7(Object object, View view, int n10, RecyclerView recyclerView) {
        super(object, view, n10);
        this.a = recyclerView;
    }

    public static d7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d7.t(view, dataBindingComponent);
    }

    public static d7 t(View view, Object object) {
        return (d7)ViewDataBinding.bind(object, view, 2131558576);
    }

    public static d7 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d7.x(layoutInflater, dataBindingComponent);
    }

    public static d7 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d7.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d7 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d7)ViewDataBinding.inflateInternal(layoutInflater, 2131558576, viewGroup, bl2, object);
    }

    public static d7 x(LayoutInflater layoutInflater, Object object) {
        return (d7)ViewDataBinding.inflateInternal(layoutInflater, 2131558576, null, false, object);
    }
}

