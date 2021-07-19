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
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class yd
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public CameraFragment$j e;
    public z f;

    public yd(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static yd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yd.t(view, dataBindingComponent);
    }

    public static yd t(View view, Object object) {
        return (yd)ViewDataBinding.bind(object, view, 2131558677);
    }

    public static yd w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yd.z(layoutInflater, dataBindingComponent);
    }

    public static yd x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yd.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yd)ViewDataBinding.inflateInternal(layoutInflater, 2131558677, viewGroup, bl2, object);
    }

    public static yd z(LayoutInflater layoutInflater, Object object) {
        return (yd)ViewDataBinding.inflateInternal(layoutInflater, 2131558677, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.e;
    }

    public z v() {
        return this.f;
    }
}

