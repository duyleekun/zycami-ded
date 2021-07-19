/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.RelativeLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhiyun.cama.main.MainFragment$d;
import com.zhiyun.cama.main.home.ExViewPager;
import d.v.c.i1.r2;

public abstract class ge
extends ViewDataBinding {
    public final BottomNavigationView a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final ImageButton d;
    public final ExViewPager e;
    public final RelativeLayout f;
    public final View g;
    public MainFragment$d h;
    public r2 i;

    public ge(Object object, View view, int n10, BottomNavigationView bottomNavigationView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageButton imageButton, ExViewPager exViewPager, RelativeLayout relativeLayout, View view2) {
        super(object, view, n10);
        this.a = bottomNavigationView;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = imageButton;
        this.e = exViewPager;
        this.f = relativeLayout;
        this.g = view2;
    }

    public static ge s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ge.t(view, dataBindingComponent);
    }

    public static ge t(View view, Object object) {
        return (ge)ViewDataBinding.bind(object, view, 2131558681);
    }

    public static ge w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ge.z(layoutInflater, dataBindingComponent);
    }

    public static ge x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ge.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ge y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ge)ViewDataBinding.inflateInternal(layoutInflater, 2131558681, viewGroup, bl2, object);
    }

    public static ge z(LayoutInflater layoutInflater, Object object) {
        return (ge)ViewDataBinding.inflateInternal(layoutInflater, 2131558681, null, false, object);
    }

    public abstract void A(MainFragment$d var1);

    public abstract void B(r2 var1);

    public MainFragment$d u() {
        return this.h;
    }

    public r2 v() {
        return this.i;
    }
}

