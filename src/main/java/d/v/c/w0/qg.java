/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceDetailFragment$b;

public abstract class qg
extends ViewDataBinding {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final FrameLayout g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public DeviceDetailFragment$b p;
    public DeviceBindViewModel q;

    public qg(Object object, View view, int n10, View view2, View view3, View view4, View view5, View view6, View view7, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(object, view, n10);
        this.a = view2;
        this.b = view3;
        this.c = view4;
        this.d = view5;
        this.e = view6;
        this.f = view7;
        this.g = frameLayout;
        this.h = imageView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = textView6;
        this.o = textView7;
    }

    public static qg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qg.t(view, dataBindingComponent);
    }

    public static qg t(View view, Object object) {
        return (qg)ViewDataBinding.bind(object, view, 2131558756);
    }

    public static qg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qg.z(layoutInflater, dataBindingComponent);
    }

    public static qg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qg)ViewDataBinding.inflateInternal(layoutInflater, 2131558756, viewGroup, bl2, object);
    }

    public static qg z(LayoutInflater layoutInflater, Object object) {
        return (qg)ViewDataBinding.inflateInternal(layoutInflater, 2131558756, null, false, object);
    }

    public abstract void A(DeviceBindViewModel var1);

    public abstract void B(DeviceDetailFragment$b var1);

    public DeviceBindViewModel u() {
        return this.q;
    }

    public DeviceDetailFragment$b v() {
        return this.p;
    }
}

