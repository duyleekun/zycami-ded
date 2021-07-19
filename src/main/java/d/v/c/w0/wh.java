/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class wh
extends ViewDataBinding {
    public final FrameLayout a;
    public final RecyclerView b;

    public wh(Object object, View view, int n10, FrameLayout frameLayout, RecyclerView recyclerView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = recyclerView;
    }

    public static wh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wh.t(view, dataBindingComponent);
    }

    public static wh t(View view, Object object) {
        return (wh)ViewDataBinding.bind(object, view, 2131558789);
    }

    public static wh u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wh.x(layoutInflater, dataBindingComponent);
    }

    public static wh v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wh.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wh)ViewDataBinding.inflateInternal(layoutInflater, 2131558789, viewGroup, bl2, object);
    }

    public static wh x(LayoutInflater layoutInflater, Object object) {
        return (wh)ViewDataBinding.inflateInternal(layoutInflater, 2131558789, null, false, object);
    }
}

