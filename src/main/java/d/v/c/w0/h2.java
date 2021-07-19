/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.Chronometer
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.widget.MutiNodeProgress;
import d.v.c.s0.u6;
import d.v.c.s0.v6;

public abstract class h2
extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final View D;
    public final View E;
    public final View F;
    public final View G;
    public CameraFragment$j H;
    public u6 I;
    public BleViewModel J;
    public v6 K;
    public DynamicZoomViewModel L;
    public DynamicZoomViewModel$TargetModel M;
    public final CheckBox a;
    public final CheckBox b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final Chronometer e;
    public final Chronometer f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;
    public final ImageView j;
    public final ImageView k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final LinearLayout n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final MutiNodeProgress q;
    public final View r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public h2(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Chronometer chronometer, Chronometer chronometer2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, MutiNodeProgress mutiNodeProgress, View view2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, View view3, View view4, View view5, View view6) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = chronometer;
        this.f = chronometer2;
        this.g = constraintLayout3;
        this.h = textView;
        this.i = textView2;
        this.j = imageView;
        this.k = imageView2;
        this.l = linearLayout;
        this.m = linearLayout2;
        this.n = linearLayout3;
        this.o = linearLayout4;
        this.p = linearLayout5;
        this.q = mutiNodeProgress;
        this.r = view2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = textView7;
        this.x = textView8;
        this.y = textView9;
        this.z = textView10;
        this.A = textView11;
        this.B = textView12;
        this.C = textView13;
        this.D = view3;
        this.E = view4;
        this.F = view5;
        this.G = view6;
    }

    public static h2 A(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h2.D(layoutInflater, dataBindingComponent);
    }

    public static h2 B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h2.C(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h2 C(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h2)ViewDataBinding.inflateInternal(layoutInflater, 2131558483, viewGroup, bl2, object);
    }

    public static h2 D(LayoutInflater layoutInflater, Object object) {
        return (h2)ViewDataBinding.inflateInternal(layoutInflater, 2131558483, null, false, object);
    }

    public static h2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h2.t(view, dataBindingComponent);
    }

    public static h2 t(View view, Object object) {
        return (h2)ViewDataBinding.bind(object, view, 2131558483);
    }

    public abstract void E(BleViewModel var1);

    public abstract void F(CameraFragment$j var1);

    public abstract void G(DynamicZoomViewModel$TargetModel var1);

    public abstract void H(DynamicZoomViewModel var1);

    public abstract void I(v6 var1);

    public abstract void J(u6 var1);

    public BleViewModel u() {
        return this.J;
    }

    public CameraFragment$j v() {
        return this.H;
    }

    public DynamicZoomViewModel$TargetModel w() {
        return this.M;
    }

    public DynamicZoomViewModel x() {
        return this.L;
    }

    public v6 y() {
        return this.K;
    }

    public u6 z() {
        return this.I;
    }
}

