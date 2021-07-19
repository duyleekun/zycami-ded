/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.publish.ComposeFragment$b;
import d.v.c.u0.l;

public abstract class z5
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final TextView h;
    public final ProgressBar i;
    public final RadioButton j;
    public final RadioButton k;
    public final RadioButton l;
    public final RadioButton m;
    public final RadioButton n;
    public final RadioButton o;
    public final RadioGroup p;
    public final RadioGroup q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public l w;
    public ComposeFragment$b x;

    public z5(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, ProgressBar progressBar, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioGroup radioGroup, RadioGroup radioGroup2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = textView;
        this.i = progressBar;
        this.j = radioButton;
        this.k = radioButton2;
        this.l = radioButton3;
        this.m = radioButton4;
        this.n = radioButton5;
        this.o = radioButton6;
        this.p = radioGroup;
        this.q = radioGroup2;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
    }

    public static z5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z5.t(view, dataBindingComponent);
    }

    public static z5 t(View view, Object object) {
        return (z5)ViewDataBinding.bind(object, view, 2131558561);
    }

    public static z5 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z5.z(layoutInflater, dataBindingComponent);
    }

    public static z5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z5.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z5)ViewDataBinding.inflateInternal(layoutInflater, 2131558561, viewGroup, bl2, object);
    }

    public static z5 z(LayoutInflater layoutInflater, Object object) {
        return (z5)ViewDataBinding.inflateInternal(layoutInflater, 2131558561, null, false, object);
    }

    public abstract void A(ComposeFragment$b var1);

    public abstract void B(l var1);

    public ComposeFragment$b u() {
        return this.x;
    }

    public l v() {
        return this.w;
    }
}

