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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.b7.k$a;
import d.v.c.s0.u6;
import d.v.c.w0.d1;
import d.v.c.w0.v0;

public abstract class x5
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final v0 b;
    public final d1 c;
    public k$a d;
    public u6 e;
    public BleViewModel f;
    public DynamicZoomViewModel g;
    public DynamicZoomViewModel$TargetModel h;

    public x5(Object object, View view, int n10, ConstraintLayout constraintLayout, v0 v02, d1 d12) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = v02;
        this.c = d12;
    }

    public static x5 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x5.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x5 B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x5)ViewDataBinding.inflateInternal(layoutInflater, 2131558560, viewGroup, bl2, object);
    }

    public static x5 C(LayoutInflater layoutInflater, Object object) {
        return (x5)ViewDataBinding.inflateInternal(layoutInflater, 2131558560, null, false, object);
    }

    public static x5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x5.t(view, dataBindingComponent);
    }

    public static x5 t(View view, Object object) {
        return (x5)ViewDataBinding.bind(object, view, 2131558560);
    }

    public static x5 z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x5.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(BleViewModel var1);

    public abstract void E(k$a var1);

    public abstract void F(DynamicZoomViewModel$TargetModel var1);

    public abstract void G(DynamicZoomViewModel var1);

    public abstract void H(u6 var1);

    public BleViewModel u() {
        return this.f;
    }

    public k$a v() {
        return this.d;
    }

    public DynamicZoomViewModel$TargetModel w() {
        return this.h;
    }

    public DynamicZoomViewModel x() {
        return this.g;
    }

    public u6 y() {
        return this.e;
    }
}

