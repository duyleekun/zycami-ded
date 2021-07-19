/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.d1$a;
import d.v.c.s0.s6;

public abstract class f1
extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public d1.a N;
    public s6 O;
    public final Button a;
    public final Button b;
    public final Guideline c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final View t;
    public final View u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public f1(Object object, View view, int n10, Button button, Button button2, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, View view2, View view3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        super(object, view, n10);
        this.a = button;
        this.b = button2;
        this.c = guideline;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = imageView8;
        this.l = imageView9;
        this.m = imageView10;
        this.n = imageView11;
        this.o = imageView12;
        this.p = imageView13;
        this.q = imageView14;
        this.r = imageView15;
        this.s = imageView16;
        this.t = view2;
        this.u = view3;
        this.v = textView;
        this.w = textView2;
        this.x = textView3;
        this.y = textView4;
        this.z = textView5;
        this.A = textView6;
        this.B = textView7;
        this.C = textView8;
        this.D = textView9;
        this.E = textView10;
        this.F = textView11;
        this.G = textView12;
        this.H = textView13;
        this.I = textView14;
        this.J = textView15;
        this.K = textView16;
        this.L = textView17;
        this.M = textView18;
    }

    public static f1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f1.t(view, dataBindingComponent);
    }

    public static f1 t(View view, Object object) {
        return (f1)ViewDataBinding.bind(object, view, 2131558469);
    }

    public static f1 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f1.z(layoutInflater, dataBindingComponent);
    }

    public static f1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f1.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f1)ViewDataBinding.inflateInternal(layoutInflater, 2131558469, viewGroup, bl2, object);
    }

    public static f1 z(LayoutInflater layoutInflater, Object object) {
        return (f1)ViewDataBinding.inflateInternal(layoutInflater, 2131558469, null, false, object);
    }

    public abstract void A(s6 var1);

    public abstract void B(d1.a var1);

    public s6 u() {
        return this.O;
    }

    public d1.a v() {
        return this.N;
    }
}

