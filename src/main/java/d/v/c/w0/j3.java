/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.zhiyun.device.connection.BleDeviceViewModel;
import d.v.c.y0.b.s$d;

public abstract class j3
extends ViewDataBinding {
    public final LottieAnimationView a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ProgressBar f;
    public final RecyclerView g;
    public final TextView h;
    public final TextView i;
    public final View j;
    public BleDeviceViewModel k;
    public boolean l;
    public boolean m;
    public s$d n;

    public j3(Object object, View view, int n10, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, View view2) {
        super(object, view, n10);
        this.a = lottieAnimationView;
        this.b = constraintLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = progressBar;
        this.g = recyclerView;
        this.h = textView;
        this.i = textView2;
        this.j = view2;
    }

    public static j3 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j3)ViewDataBinding.inflateInternal(layoutInflater, 2131558515, viewGroup, bl2, object);
    }

    public static j3 B(LayoutInflater layoutInflater, Object object) {
        return (j3)ViewDataBinding.inflateInternal(layoutInflater, 2131558515, null, false, object);
    }

    public static j3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j3.t(view, dataBindingComponent);
    }

    public static j3 t(View view, Object object) {
        return (j3)ViewDataBinding.bind(object, view, 2131558515);
    }

    public static j3 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j3.B(layoutInflater, dataBindingComponent);
    }

    public static j3 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j3.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(boolean var1);

    public abstract void D(s$d var1);

    public abstract void E(boolean var1);

    public abstract void F(BleDeviceViewModel var1);

    public boolean u() {
        return this.m;
    }

    public s$d v() {
        return this.n;
    }

    public boolean w() {
        return this.l;
    }

    public BleDeviceViewModel x() {
        return this.k;
    }
}

