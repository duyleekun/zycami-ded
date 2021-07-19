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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public abstract class p8
extends ViewDataBinding {
    public final RecyclerView a;
    public final SwipeRefreshLayout b;

    public p8(Object object, View view, int n10, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        super(object, view, n10);
        this.a = recyclerView;
        this.b = swipeRefreshLayout;
    }

    public static p8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p8.t(view, dataBindingComponent);
    }

    public static p8 t(View view, Object object) {
        return (p8)ViewDataBinding.bind(object, view, 2131558595);
    }

    public static p8 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p8.x(layoutInflater, dataBindingComponent);
    }

    public static p8 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p8.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p8 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p8)ViewDataBinding.inflateInternal(layoutInflater, 2131558595, viewGroup, bl2, object);
    }

    public static p8 x(LayoutInflater layoutInflater, Object object) {
        return (p8)ViewDataBinding.inflateInternal(layoutInflater, 2131558595, null, false, object);
    }
}

