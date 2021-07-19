/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.template.PlayLayout;
import d.v.c.u1.l.l$c;
import d.v.c.u1.l.m;
import d.v.j.f.g;

public abstract class x7
extends ViewDataBinding {
    public final FrameLayout a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ProgressBar d;
    public final PlayLayout e;
    public final TextView f;
    public final ImageButton g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final ImageButton o;
    public m p;
    public g q;
    public l$c r;

    public x7(Object object, View view, int n10, FrameLayout frameLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, PlayLayout playLayout, TextView textView, ImageButton imageButton, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ImageButton imageButton2) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = progressBar;
        this.e = playLayout;
        this.f = textView;
        this.g = imageButton;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = textView7;
        this.n = textView8;
        this.o = imageButton2;
    }

    public static x7 A(LayoutInflater layoutInflater, Object object) {
        return (x7)ViewDataBinding.inflateInternal(layoutInflater, 2131558586, null, false, object);
    }

    public static x7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x7.t(view, dataBindingComponent);
    }

    public static x7 t(View view, Object object) {
        return (x7)ViewDataBinding.bind(object, view, 2131558586);
    }

    public static x7 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x7.A(layoutInflater, dataBindingComponent);
    }

    public static x7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x7.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x7 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x7)ViewDataBinding.inflateInternal(layoutInflater, 2131558586, viewGroup, bl2, object);
    }

    public abstract void B(l$c var1);

    public abstract void C(m var1);

    public abstract void D(g var1);

    public l$c u() {
        return this.r;
    }

    public m v() {
        return this.p;
    }

    public g w() {
        return this.q;
    }
}

