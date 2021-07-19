/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.internal.FlowLayout;
import com.zhiyun.cama.publish.PublishFragment$f;
import d.v.c.n1.j2;
import d.v.c.q1.g0;
import d.v.c.u0.l;

public abstract class gg
extends ViewDataBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final View F;
    public final View G;
    public final View H;
    public final View I;
    public final View J;
    public final View K;
    public PublishFragment$f L;
    public l M;
    public g0 N;
    public j2 O;
    public final CheckBox a;
    public final CheckedTextView b;
    public final ConstraintLayout c;
    public final EditText d;
    public final FrameLayout e;
    public final FlowLayout f;
    public final FrameLayout g;
    public final ConstraintLayout h;
    public final FlowLayout i;
    public final FrameLayout j;
    public final ImageView k;
    public final ImageView l;
    public final TextView m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final ProgressBar t;
    public final ProgressBar u;
    public final ProgressBar v;
    public final ScrollView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public gg(Object object, View view, int n10, CheckBox checkBox, CheckedTextView checkedTextView, ConstraintLayout constraintLayout, EditText editText, FrameLayout frameLayout, FlowLayout flowLayout, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, FlowLayout flowLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ScrollView scrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2, View view3, View view4, View view5, View view6, View view7) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkedTextView;
        this.c = constraintLayout;
        this.d = editText;
        this.e = frameLayout;
        this.f = flowLayout;
        this.g = frameLayout2;
        this.h = constraintLayout2;
        this.i = flowLayout2;
        this.j = frameLayout3;
        this.k = imageView;
        this.l = imageView2;
        this.m = textView;
        this.n = imageView3;
        this.o = imageView4;
        this.p = imageView5;
        this.q = imageView6;
        this.r = linearLayout;
        this.s = linearLayout2;
        this.t = progressBar;
        this.u = progressBar2;
        this.v = progressBar3;
        this.w = scrollView;
        this.x = textView2;
        this.y = textView3;
        this.z = textView4;
        this.A = textView5;
        this.B = textView6;
        this.C = textView7;
        this.D = textView8;
        this.E = textView9;
        this.F = view2;
        this.G = view3;
        this.H = view4;
        this.I = view5;
        this.J = view6;
        this.K = view7;
    }

    public static gg A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gg)ViewDataBinding.inflateInternal(layoutInflater, 2131558747, viewGroup, bl2, object);
    }

    public static gg B(LayoutInflater layoutInflater, Object object) {
        return (gg)ViewDataBinding.inflateInternal(layoutInflater, 2131558747, null, false, object);
    }

    public static gg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gg.t(view, dataBindingComponent);
    }

    public static gg t(View view, Object object) {
        return (gg)ViewDataBinding.bind(object, view, 2131558747);
    }

    public static gg y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gg.B(layoutInflater, dataBindingComponent);
    }

    public static gg z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gg.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(PublishFragment$f var1);

    public abstract void D(l var1);

    public abstract void E(j2 var1);

    public abstract void F(g0 var1);

    public PublishFragment$f u() {
        return this.L;
    }

    public l v() {
        return this.M;
    }

    public j2 w() {
        return this.O;
    }

    public g0 x() {
        return this.N;
    }
}

