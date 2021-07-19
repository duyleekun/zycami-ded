/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.u6;

public abstract class yh
extends ViewDataBinding {
    public final CheckBox a;
    public final ExoVideoView b;
    public final ConstraintLayout c;
    public final Guideline d;
    public final Guideline e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final View l;
    public final ImageView m;
    public final Guideline n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final RecyclerView q;
    public final StoryProgressBar r;
    public final TextView s;
    public final TextView t;
    public final View u;
    public l v;
    public m0 w;
    public u6 x;
    public BleViewModel y;
    public CameraFragment$j z;

    public yh(Object object, View view, int n10, CheckBox checkBox, ExoVideoView exoVideoView, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, View view2, ImageView imageView7, Guideline guideline3, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, StoryProgressBar storyProgressBar, TextView textView, TextView textView2, View view3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = exoVideoView;
        this.c = constraintLayout;
        this.d = guideline;
        this.e = guideline2;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = imageView5;
        this.k = imageView6;
        this.l = view2;
        this.m = imageView7;
        this.n = guideline3;
        this.o = linearLayout;
        this.p = linearLayout2;
        this.q = recyclerView;
        this.r = storyProgressBar;
        this.s = textView;
        this.t = textView2;
        this.u = view3;
    }

    public static yh A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yh.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yh B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yh)ViewDataBinding.inflateInternal(layoutInflater, 2131558790, viewGroup, bl2, object);
    }

    public static yh C(LayoutInflater layoutInflater, Object object) {
        return (yh)ViewDataBinding.inflateInternal(layoutInflater, 2131558790, null, false, object);
    }

    public static yh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yh.t(view, dataBindingComponent);
    }

    public static yh t(View view, Object object) {
        return (yh)ViewDataBinding.bind(object, view, 2131558790);
    }

    public static yh z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yh.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(BleViewModel var1);

    public abstract void E(u6 var1);

    public abstract void F(CameraFragment$j var1);

    public abstract void G(l var1);

    public abstract void H(m0 var1);

    public BleViewModel u() {
        return this.y;
    }

    public u6 v() {
        return this.x;
    }

    public CameraFragment$j w() {
        return this.z;
    }

    public l x() {
        return this.v;
    }

    public m0 y() {
        return this.w;
    }
}

