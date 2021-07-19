/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ScrollView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.EditorMainActivity$b;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.i1.i2;
import d.v.c.w0.ui;

public abstract class k
extends ViewDataBinding {
    public final Button a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ZYTextView h;
    public final PlayerWrapperView i;
    public final ZYTextView j;
    public final ConstraintLayout k;
    public final ScrollView l;
    public final AppCompatSeekBar m;
    public final ui n;
    public final ImageView o;
    public final ImageView p;
    public i2 q;
    public EditorMainActivity$b r;

    public k(Object object, View view, int n10, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ZYTextView zYTextView, PlayerWrapperView playerWrapperView, ZYTextView zYTextView2, ConstraintLayout constraintLayout3, ScrollView scrollView, AppCompatSeekBar appCompatSeekBar, ui ui2, ImageView imageView3, ImageView imageView4) {
        super(object, view, n10);
        this.a = button;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = imageView;
        this.g = imageView2;
        this.h = zYTextView;
        this.i = playerWrapperView;
        this.j = zYTextView2;
        this.k = constraintLayout3;
        this.l = scrollView;
        this.m = appCompatSeekBar;
        this.n = ui2;
        this.o = imageView3;
        this.p = imageView4;
    }

    public static k s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.k.t(view, dataBindingComponent);
    }

    public static k t(View view, Object object) {
        return (k)ViewDataBinding.bind(object, view, 2131558435);
    }

    public static k w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.k.z(layoutInflater, dataBindingComponent);
    }

    public static k x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.k.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static k y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (k)ViewDataBinding.inflateInternal(layoutInflater, 2131558435, viewGroup, bl2, object);
    }

    public static k z(LayoutInflater layoutInflater, Object object) {
        return (k)ViewDataBinding.inflateInternal(layoutInflater, 2131558435, null, false, object);
    }

    public abstract void A(EditorMainActivity$b var1);

    public abstract void B(i2 var1);

    public EditorMainActivity$b u() {
        return this.r;
    }

    public i2 v() {
        return this.q;
    }
}

