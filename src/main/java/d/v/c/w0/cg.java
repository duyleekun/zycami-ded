/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.m1.d.k$a;

public abstract class cg
extends ViewDataBinding {
    public final Button a;
    public final Button b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;
    public k$a k;

    public cg(Object object, View view, int n10, Button button, Button button2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = button;
        this.b = button2;
        this.c = constraintLayout;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = textView;
        this.j = textView2;
    }

    public static cg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cg.t(view, dataBindingComponent);
    }

    public static cg t(View view, Object object) {
        return (cg)ViewDataBinding.bind(object, view, 2131558744);
    }

    public static cg v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cg.y(layoutInflater, dataBindingComponent);
    }

    public static cg w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cg.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static cg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (cg)ViewDataBinding.inflateInternal(layoutInflater, 2131558744, viewGroup, bl2, object);
    }

    public static cg y(LayoutInflater layoutInflater, Object object) {
        return (cg)ViewDataBinding.inflateInternal(layoutInflater, 2131558744, null, false, object);
    }

    public k$a u() {
        return this.k;
    }

    public abstract void z(k$a var1);
}

