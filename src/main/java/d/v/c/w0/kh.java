/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class kh
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Integer h;

    public kh(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
    }

    public static kh A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kh)ViewDataBinding.inflateInternal(layoutInflater, 2131558783, viewGroup, bl2, object);
    }

    public static kh B(LayoutInflater layoutInflater, Object object) {
        return (kh)ViewDataBinding.inflateInternal(layoutInflater, 2131558783, null, false, object);
    }

    public static kh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kh.t(view, dataBindingComponent);
    }

    public static kh t(View view, Object object) {
        return (kh)ViewDataBinding.bind(object, view, 2131558783);
    }

    public static kh y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kh.B(layoutInflater, dataBindingComponent);
    }

    public static kh z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kh.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(Integer var1);

    public abstract void D(Integer var1);

    public abstract void E(Integer var1);

    public abstract void F(Integer var1);

    public Integer u() {
        return this.e;
    }

    public Integer v() {
        return this.h;
    }

    public Integer w() {
        return this.g;
    }

    public Integer x() {
        return this.f;
    }
}

