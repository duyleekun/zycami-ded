/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.ShadowContainer;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.p$c;
import d.v.c.s0.h7.p0.q;

public abstract class l9
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final RecyclerView g;
    public final ShadowContainer h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final VideoView m;
    public final View n;
    public final View o;
    public q p;
    public m0 q;
    public p.c r;

    public l9(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RecyclerView recyclerView, ShadowContainer shadowContainer, TextView textView, TextView textView2, TextView textView3, View view2, VideoView videoView, View view3, View view4) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = recyclerView;
        this.h = shadowContainer;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = view2;
        this.m = videoView;
        this.n = view3;
        this.o = view4;
    }

    public static l9 A(LayoutInflater layoutInflater, Object object) {
        return (l9)ViewDataBinding.inflateInternal(layoutInflater, 2131558606, null, false, object);
    }

    public static l9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l9.t(view, dataBindingComponent);
    }

    public static l9 t(View view, Object object) {
        return (l9)ViewDataBinding.bind(object, view, 2131558606);
    }

    public static l9 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l9.A(layoutInflater, dataBindingComponent);
    }

    public static l9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l9.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l9)ViewDataBinding.inflateInternal(layoutInflater, 2131558606, viewGroup, bl2, object);
    }

    public abstract void B(p.c var1);

    public abstract void C(m0 var1);

    public abstract void D(q var1);

    public p.c u() {
        return this.r;
    }

    public m0 v() {
        return this.q;
    }

    public q w() {
        return this.p;
    }
}

