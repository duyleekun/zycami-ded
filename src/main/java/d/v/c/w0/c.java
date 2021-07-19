/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.p0.m;
import d.v.c.w0.v2;

public abstract class c
extends ViewDataBinding {
    public final Button a;
    public final EditText b;
    public final RecyclerView c;
    public final ScrollView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final v2 i;
    public m j;

    public c(Object object, View view, int n10, Button button, EditText editText, RecyclerView recyclerView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, v2 v22) {
        super(object, view, n10);
        this.a = button;
        this.b = editText;
        this.c = recyclerView;
        this.d = scrollView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = v22;
    }

    public static c s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.c.t(view, dataBindingComponent);
    }

    public static c t(View view, Object object) {
        return (c)ViewDataBinding.bind(object, view, 2131558429);
    }

    public static c v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.c.y(layoutInflater, dataBindingComponent);
    }

    public static c w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.c.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static c x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (c)ViewDataBinding.inflateInternal(layoutInflater, 2131558429, viewGroup, bl2, object);
    }

    public static c y(LayoutInflater layoutInflater, Object object) {
        return (c)ViewDataBinding.inflateInternal(layoutInflater, 2131558429, null, false, object);
    }

    public m u() {
        return this.j;
    }

    public abstract void z(m var1);
}

