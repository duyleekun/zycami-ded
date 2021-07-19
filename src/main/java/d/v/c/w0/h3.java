/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.q1.h0.k0$a;
import d.v.e0.td;

public abstract class h3
extends ViewDataBinding {
    public final View a;
    public final View b;
    public final ConstraintLayout c;
    public final Guideline d;
    public final LinearLayout e;
    public final Button f;
    public final Button g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public k0$a l;
    public td m;

    public h3(Object object, View view, int n10, View view2, View view3, ConstraintLayout constraintLayout, Guideline guideline, LinearLayout linearLayout, Button button, Button button2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = view2;
        this.b = view3;
        this.c = constraintLayout;
        this.d = guideline;
        this.e = linearLayout;
        this.f = button;
        this.g = button2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
    }

    public static h3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h3.t(view, dataBindingComponent);
    }

    public static h3 t(View view, Object object) {
        return (h3)ViewDataBinding.bind(object, view, 2131558514);
    }

    public static h3 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h3.z(layoutInflater, dataBindingComponent);
    }

    public static h3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h3.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h3 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h3)ViewDataBinding.inflateInternal(layoutInflater, 2131558514, viewGroup, bl2, object);
    }

    public static h3 z(LayoutInflater layoutInflater, Object object) {
        return (h3)ViewDataBinding.inflateInternal(layoutInflater, 2131558514, null, false, object);
    }

    public abstract void A(k0$a var1);

    public abstract void B(td var1);

    public k0$a u() {
        return this.l;
    }

    public td v() {
        return this.m;
    }
}

