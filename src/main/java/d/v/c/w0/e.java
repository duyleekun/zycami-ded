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
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.p0.n.j;
import d.v.c.w0.v2;

public abstract class e
extends ViewDataBinding {
    public final RecyclerView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final View j;
    public final v2 k;
    public final TextView l;
    public j m;

    public e(Object object, View view, int n10, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2, v2 v22, TextView textView9) {
        super(object, view, n10);
        this.a = recyclerView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = textView5;
        this.g = textView6;
        this.h = textView7;
        this.i = textView8;
        this.j = view2;
        this.k = v22;
        this.l = textView9;
    }

    public static e s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.e.t(view, dataBindingComponent);
    }

    public static e t(View view, Object object) {
        return (e)ViewDataBinding.bind(object, view, 2131558430);
    }

    public static e v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.e.y(layoutInflater, dataBindingComponent);
    }

    public static e w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.e.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static e x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (e)ViewDataBinding.inflateInternal(layoutInflater, 2131558430, viewGroup, bl2, object);
    }

    public static e y(LayoutInflater layoutInflater, Object object) {
        return (e)ViewDataBinding.inflateInternal(layoutInflater, 2131558430, null, false, object);
    }

    public j u() {
        return this.m;
    }

    public abstract void z(j var1);
}

