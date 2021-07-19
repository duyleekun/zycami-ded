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
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.s0.d7.z;
import d.v.c.w0.kd;
import d.v.c.w0.md;
import d.v.c.w0.od;
import d.v.c.w0.qd;
import d.v.c.w0.sd;
import d.v.c.w0.ud;
import d.v.c.w0.wd;
import d.v.c.w0.yd;

public abstract class si
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final od b;
    public final kd c;
    public final md d;
    public final qd e;
    public final sd f;
    public final ud g;
    public final wd h;
    public final yd i;
    public final ZYTextView j;
    public CameraFragment$j k;
    public z l;

    public si(Object object, View view, int n10, ConstraintLayout constraintLayout, od od2, kd kd2, md md2, qd qd2, sd sd2, ud ud2, wd wd2, yd yd2, ZYTextView zYTextView) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = od2;
        this.c = kd2;
        this.d = md2;
        this.e = qd2;
        this.f = sd2;
        this.g = ud2;
        this.h = wd2;
        this.i = yd2;
        this.j = zYTextView;
    }

    public static si s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return si.t(view, dataBindingComponent);
    }

    public static si t(View view, Object object) {
        return (si)ViewDataBinding.bind(object, view, 2131558813);
    }

    public static si w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return si.z(layoutInflater, dataBindingComponent);
    }

    public static si x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return si.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static si y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (si)ViewDataBinding.inflateInternal(layoutInflater, 2131558813, viewGroup, bl2, object);
    }

    public static si z(LayoutInflater layoutInflater, Object object) {
        return (si)ViewDataBinding.inflateInternal(layoutInflater, 2131558813, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.k;
    }

    public z v() {
        return this.l;
    }
}

