/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import d.v.c.y1.f.p$b;
import d.v.c.y1.f.u;

public abstract class z6
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioButton f;
    public final RadioGroup g;
    public final TextView h;
    public final TextView i;
    public final ViewPager2 j;
    public u k;
    public p$b l;

    public z6(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, TextView textView, TextView textView2, ViewPager2 viewPager2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = imageView;
        this.d = radioButton;
        this.e = radioButton2;
        this.f = radioButton3;
        this.g = radioGroup;
        this.h = textView;
        this.i = textView2;
        this.j = viewPager2;
    }

    public static z6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z6.t(view, dataBindingComponent);
    }

    public static z6 t(View view, Object object) {
        return (z6)ViewDataBinding.bind(object, view, 2131558573);
    }

    public static z6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z6.z(layoutInflater, dataBindingComponent);
    }

    public static z6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z6)ViewDataBinding.inflateInternal(layoutInflater, 2131558573, viewGroup, bl2, object);
    }

    public static z6 z(LayoutInflater layoutInflater, Object object) {
        return (z6)ViewDataBinding.inflateInternal(layoutInflater, 2131558573, null, false, object);
    }

    public abstract void A(p$b var1);

    public abstract void B(u var1);

    public p$b u() {
        return this.l;
    }

    public u v() {
        return this.k;
    }
}

