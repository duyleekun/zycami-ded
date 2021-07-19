/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.home.ExViewPager;
import com.zhiyun.cama.main.me.MeFragment$b;
import d.v.c.i1.t2.i0;
import d.v.c.m1.c;

public abstract class cf
extends ViewDataBinding {
    public final View A;
    public final View B;
    public final ExViewPager C;
    public MeFragment$b D;
    public i0 E;
    public c F;
    public final RadioGroup a;
    public final ConstraintLayout b;
    public final RelativeLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final LinearLayout o;
    public final ProgressBar p;
    public final RadioButton q;
    public final RadioButton r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public cf(Object object, View view, int n10, RadioGroup radioGroup, ConstraintLayout constraintLayout, RelativeLayout relativeLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout, ProgressBar progressBar, RadioButton radioButton, RadioButton radioButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2, View view3, ExViewPager exViewPager) {
        super(object, view, n10);
        this.a = radioGroup;
        this.b = constraintLayout;
        this.c = relativeLayout;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = imageView5;
        this.k = imageView6;
        this.l = imageView7;
        this.m = imageView8;
        this.n = imageView9;
        this.o = linearLayout;
        this.p = progressBar;
        this.q = radioButton;
        this.r = radioButton2;
        this.s = textView;
        this.t = textView2;
        this.u = textView3;
        this.v = textView4;
        this.w = textView5;
        this.x = textView6;
        this.y = textView7;
        this.z = textView8;
        this.A = view2;
        this.B = view3;
        this.C = exViewPager;
    }

    public static cf A(LayoutInflater layoutInflater, Object object) {
        return (cf)ViewDataBinding.inflateInternal(layoutInflater, 2131558703, null, false, object);
    }

    public static cf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cf.t(view, dataBindingComponent);
    }

    public static cf t(View view, Object object) {
        return (cf)ViewDataBinding.bind(object, view, 2131558703);
    }

    public static cf x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cf.A(layoutInflater, dataBindingComponent);
    }

    public static cf y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cf.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static cf z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (cf)ViewDataBinding.inflateInternal(layoutInflater, 2131558703, viewGroup, bl2, object);
    }

    public abstract void B(MeFragment$b var1);

    public abstract void C(c var1);

    public abstract void D(i0 var1);

    public MeFragment$b u() {
        return this.D;
    }

    public c v() {
        return this.F;
    }

    public i0 w() {
        return this.E;
    }
}

