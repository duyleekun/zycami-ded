/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.m1.d.l$a;
import d.v.c.m1.d.m;

public abstract class f3
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final View f;
    public l$a g;
    public m h;

    public f3(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = view2;
    }

    public static f3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f3.t(view, dataBindingComponent);
    }

    public static f3 t(View view, Object object) {
        return (f3)ViewDataBinding.bind(object, view, 2131558513);
    }

    public static f3 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f3.z(layoutInflater, dataBindingComponent);
    }

    public static f3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f3.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f3 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f3)ViewDataBinding.inflateInternal(layoutInflater, 2131558513, viewGroup, bl2, object);
    }

    public static f3 z(LayoutInflater layoutInflater, Object object) {
        return (f3)ViewDataBinding.inflateInternal(layoutInflater, 2131558513, null, false, object);
    }

    public abstract void A(l$a var1);

    public abstract void B(m var1);

    public l$a u() {
        return this.g;
    }

    public m v() {
        return this.h;
    }
}

