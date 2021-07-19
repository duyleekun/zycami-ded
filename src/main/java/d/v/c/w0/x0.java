/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.android.CameraView;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.widget.HintLayout;
import com.zhiyun.cama.camera.widget.ModeSwitch;
import com.zhiyun.cama.camera.widget.PartitionSeekBar;
import com.zhiyun.cama.camera.widget.TrackView;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.c.s0.d7.z;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.s0.v6;
import d.v.c.s0.w6;
import d.v.c.w0.h2;
import d.v.g.g.c1;

public abstract class x0
extends ViewDataBinding {
    public final LinearLayout A;
    public l A0;
    public final LinearLayout B;
    public final ConstraintLayout C;
    public final LinearLayout D;
    public final ModeSwitch E;
    public final View F;
    public final RelativeLayout G;
    public final RelativeLayout H;
    public final PartitionSeekBar I;
    public final ImageView J;
    public final ViewStubProxy K;
    public final TrackView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final View Q;
    public final View R;
    public final View S;
    public final View T;
    public final View U;
    public final View V;
    public final View W;
    public final View X;
    public final View Y;
    public final View Z;
    public final CameraView a;
    public final CheckedTextView b;
    public final CheckBox c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final ConstraintLayout f;
    public final LottieAnimationView g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final HintLayout j;
    public final h2 k;
    public final ViewStubProxy k0;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public u6 o0;
    public final ImageView p;
    public s6 p0;
    public final ImageView q;
    public m0 q0;
    public final ImageView r;
    public BleViewModel r0;
    public final ImageView s;
    public DeviceViewModel s0;
    public final ImageView t;
    public w6 t0;
    public final ImageView u;
    public c1 u0;
    public final ImageView v;
    public v6 v0;
    public final ImageView w;
    public CameraFragment$j w0;
    public final ImageView x;
    public z x0;
    public final ImageView y;
    public DynamicZoomViewModel y0;
    public final ImageView z;
    public DynamicZoomViewModel$TargetModel z0;

    public x0(Object object, View view, int n10, CameraView cameraView, CheckedTextView checkedTextView, CheckBox checkBox, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LottieAnimationView lottieAnimationView, FrameLayout frameLayout, FrameLayout frameLayout2, HintLayout hintLayout, h2 h22, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout4, LinearLayout linearLayout3, ModeSwitch modeSwitch, View view2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, PartitionSeekBar partitionSeekBar, ImageView imageView16, ViewStubProxy viewStubProxy, TrackView trackView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, View view12, ViewStubProxy viewStubProxy2) {
        super(object, view, n10);
        this.a = cameraView;
        this.b = checkedTextView;
        this.c = checkBox;
        this.d = constraintLayout;
        this.e = constraintLayout2;
        this.f = constraintLayout3;
        this.g = lottieAnimationView;
        this.h = frameLayout;
        this.i = frameLayout2;
        this.j = hintLayout;
        this.k = h22;
        this.l = imageView;
        this.m = imageView2;
        this.n = imageView3;
        this.o = imageView4;
        this.p = imageView5;
        this.q = imageView6;
        this.r = imageView7;
        this.s = imageView8;
        this.t = imageView9;
        this.u = imageView10;
        this.v = imageView11;
        this.w = imageView12;
        this.x = imageView13;
        this.y = imageView14;
        this.z = imageView15;
        this.A = linearLayout;
        this.B = linearLayout2;
        this.C = constraintLayout4;
        this.D = linearLayout3;
        this.E = modeSwitch;
        this.F = view2;
        this.G = relativeLayout;
        this.H = relativeLayout2;
        this.I = partitionSeekBar;
        this.J = imageView16;
        this.K = viewStubProxy;
        this.L = trackView;
        this.M = textView;
        this.N = textView2;
        this.O = textView3;
        this.P = textView4;
        this.Q = view3;
        this.R = view4;
        this.S = view5;
        this.T = view6;
        this.U = view7;
        this.V = view8;
        this.W = view9;
        this.X = view10;
        this.Y = view11;
        this.Z = view12;
        this.k0 = viewStubProxy2;
    }

    public static x0 H(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.x0.K(layoutInflater, dataBindingComponent);
    }

    public static x0 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.x0.J(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x0 J(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x0)ViewDataBinding.inflateInternal(layoutInflater, 2131558465, viewGroup, bl2, object);
    }

    public static x0 K(LayoutInflater layoutInflater, Object object) {
        return (x0)ViewDataBinding.inflateInternal(layoutInflater, 2131558465, null, false, object);
    }

    public static x0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.x0.t(view, dataBindingComponent);
    }

    public static x0 t(View view, Object object) {
        return (x0)ViewDataBinding.bind(object, view, 2131558465);
    }

    public z A() {
        return this.x0;
    }

    public v6 B() {
        return this.v0;
    }

    public l C() {
        return this.A0;
    }

    public m0 D() {
        return this.q0;
    }

    public w6 E() {
        return this.t0;
    }

    public s6 F() {
        return this.p0;
    }

    public u6 G() {
        return this.o0;
    }

    public abstract void L(BleViewModel var1);

    public abstract void M(CameraFragment$j var1);

    public abstract void N(DeviceViewModel var1);

    public abstract void O(DynamicZoomViewModel$TargetModel var1);

    public abstract void P(DynamicZoomViewModel var1);

    public abstract void Q(c1 var1);

    public abstract void R(z var1);

    public abstract void S(v6 var1);

    public abstract void T(l var1);

    public abstract void U(m0 var1);

    public abstract void V(w6 var1);

    public abstract void W(s6 var1);

    public abstract void X(u6 var1);

    public BleViewModel u() {
        return this.r0;
    }

    public CameraFragment$j v() {
        return this.w0;
    }

    public DeviceViewModel w() {
        return this.s0;
    }

    public DynamicZoomViewModel$TargetModel x() {
        return this.z0;
    }

    public DynamicZoomViewModel y() {
        return this.y0;
    }

    public c1 z() {
        return this.u0;
    }
}

