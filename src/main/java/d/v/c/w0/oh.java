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
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import d.v.c.s0.h7.r0.r$d;
import d.v.c.s0.h7.r0.s;

public abstract class oh
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final TabLayout c;
    public final TextView d;
    public final ViewPager e;
    public r.d f;
    public s g;

    public oh(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, TabLayout tabLayout, TextView textView, ViewPager viewPager) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = tabLayout;
        this.d = textView;
        this.e = viewPager;
    }

    public static oh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oh.t(view, dataBindingComponent);
    }

    public static oh t(View view, Object object) {
        return (oh)ViewDataBinding.bind(object, view, 2131558785);
    }

    public static oh w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oh.z(layoutInflater, dataBindingComponent);
    }

    public static oh x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oh.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static oh y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (oh)ViewDataBinding.inflateInternal(layoutInflater, 2131558785, viewGroup, bl2, object);
    }

    public static oh z(LayoutInflater layoutInflater, Object object) {
        return (oh)ViewDataBinding.inflateInternal(layoutInflater, 2131558785, null, false, object);
    }

    public abstract void A(r.d var1);

    public abstract void B(s var1);

    public r.d u() {
        return this.f;
    }

    public s v() {
        return this.g;
    }
}

