/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.b7.k$a;
import d.v.c.s0.u6;

public abstract class v0
extends ViewDataBinding {
    public final Guideline a;
    public final Guideline b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final LottieAnimationView f;
    public final View g;
    public final LottieAnimationView h;
    public final TextView i;
    public final Guideline j;
    public final Guideline k;
    public final Guideline l;
    public final ImageView m;
    public final View n;
    public final Guideline o;
    public final Guideline p;
    public final Guideline q;
    public final TextView r;
    public final Guideline s;
    public k$a t;
    public DynamicZoomViewModel u;
    public BleViewModel v;
    public DynamicZoomViewModel$TargetModel w;
    public u6 x;

    public v0(Object object, View view, int n10, Guideline guideline, Guideline guideline2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LottieAnimationView lottieAnimationView, View view2, LottieAnimationView lottieAnimationView2, TextView textView, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, View view3, Guideline guideline6, Guideline guideline7, Guideline guideline8, TextView textView2, Guideline guideline9) {
        super(object, view, n10);
        this.a = guideline;
        this.b = guideline2;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = constraintLayout3;
        this.f = lottieAnimationView;
        this.g = view2;
        this.h = lottieAnimationView2;
        this.i = textView;
        this.j = guideline3;
        this.k = guideline4;
        this.l = guideline5;
        this.m = imageView;
        this.n = view3;
        this.o = guideline6;
        this.p = guideline7;
        this.q = guideline8;
        this.r = textView2;
        this.s = guideline9;
    }

    public static v0 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v0.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v0 B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v0)ViewDataBinding.inflateInternal(layoutInflater, 2131558464, viewGroup, bl2, object);
    }

    public static v0 C(LayoutInflater layoutInflater, Object object) {
        return (v0)ViewDataBinding.inflateInternal(layoutInflater, 2131558464, null, false, object);
    }

    public static v0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v0.t(view, dataBindingComponent);
    }

    public static v0 t(View view, Object object) {
        return (v0)ViewDataBinding.bind(object, view, 2131558464);
    }

    public static v0 z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v0.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(BleViewModel var1);

    public abstract void E(k$a var1);

    public abstract void F(DynamicZoomViewModel$TargetModel var1);

    public abstract void G(DynamicZoomViewModel var1);

    public abstract void H(u6 var1);

    public BleViewModel u() {
        return this.v;
    }

    public k$a v() {
        return this.t;
    }

    public DynamicZoomViewModel$TargetModel w() {
        return this.w;
    }

    public DynamicZoomViewModel x() {
        return this.u;
    }

    public u6 y() {
        return this.x;
    }
}

