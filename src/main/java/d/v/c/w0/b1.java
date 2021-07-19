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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import d.v.c.s0.a7.c1$b;
import d.v.c.s0.s6;

public abstract class b1
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ViewPager2 g;
    public final ViewPager2 h;
    public c1.b i;
    public s6 j;

    public b1(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, ViewPager2 viewPager2, ViewPager2 viewPager22) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = viewPager2;
        this.h = viewPager22;
    }

    public static b1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b1.t(view, dataBindingComponent);
    }

    public static b1 t(View view, Object object) {
        return (b1)ViewDataBinding.bind(object, view, 2131558467);
    }

    public static b1 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b1.z(layoutInflater, dataBindingComponent);
    }

    public static b1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b1.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b1)ViewDataBinding.inflateInternal(layoutInflater, 2131558467, viewGroup, bl2, object);
    }

    public static b1 z(LayoutInflater layoutInflater, Object object) {
        return (b1)ViewDataBinding.inflateInternal(layoutInflater, 2131558467, null, false, object);
    }

    public abstract void A(s6 var1);

    public abstract void B(c1.b var1);

    public s6 u() {
        return this.j;
    }

    public c1.b v() {
        return this.i;
    }
}

