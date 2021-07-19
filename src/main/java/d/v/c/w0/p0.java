/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.c.s0.d7.z;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.s0.v6;
import d.v.c.s0.w6;
import d.v.g.g.c1;

public abstract class p0
extends ViewDataBinding {
    public final CheckedTextView a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ConstraintLayout k;
    public u6 l;
    public s6 m;
    public m0 n;
    public BleViewModel o;
    public DeviceViewModel p;
    public w6 q;
    public c1 r;
    public v6 s;
    public CameraFragment$j t;
    public z u;
    public DynamicZoomViewModel v;
    public DynamicZoomViewModel$TargetModel w;
    public l x;

    public p0(Object object, View view, int n10, CheckedTextView checkedTextView, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout2) {
        super(object, view, n10);
        this.a = checkedTextView;
        this.b = constraintLayout;
        this.c = frameLayout;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = constraintLayout2;
    }

    public static p0 H(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p0.K(layoutInflater, dataBindingComponent);
    }

    public static p0 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p0.J(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p0 J(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p0)ViewDataBinding.inflateInternal(layoutInflater, 2131558461, viewGroup, bl2, object);
    }

    public static p0 K(LayoutInflater layoutInflater, Object object) {
        return (p0)ViewDataBinding.inflateInternal(layoutInflater, 2131558461, null, false, object);
    }

    public static p0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p0.t(view, dataBindingComponent);
    }

    public static p0 t(View view, Object object) {
        return (p0)ViewDataBinding.bind(object, view, 2131558461);
    }

    public z A() {
        return this.u;
    }

    public v6 B() {
        return this.s;
    }

    public l C() {
        return this.x;
    }

    public m0 D() {
        return this.n;
    }

    public w6 E() {
        return this.q;
    }

    public s6 F() {
        return this.m;
    }

    public u6 G() {
        return this.l;
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
        return this.o;
    }

    public CameraFragment$j v() {
        return this.t;
    }

    public DeviceViewModel w() {
        return this.p;
    }

    public DynamicZoomViewModel$TargetModel x() {
        return this.w;
    }

    public DynamicZoomViewModel y() {
        return this.v;
    }

    public c1 z() {
        return this.r;
    }
}

