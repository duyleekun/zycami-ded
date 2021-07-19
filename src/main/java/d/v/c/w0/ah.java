/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.zhiyun.cama.splash.SplashFragment$c;
import d.v.c.t1.s;

public abstract class ah
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final VideoView i;
    public final VideoView j;
    public final ViewPager k;
    public s l;
    public SplashFragment$c m;

    public ah(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, VideoView videoView, VideoView videoView2, ViewPager viewPager) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = linearLayout;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = videoView;
        this.j = videoView2;
        this.k = viewPager;
    }

    public static ah s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ah.t(view, dataBindingComponent);
    }

    public static ah t(View view, Object object) {
        return (ah)ViewDataBinding.bind(object, view, 2131558778);
    }

    public static ah w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ah.z(layoutInflater, dataBindingComponent);
    }

    public static ah x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ah.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ah y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ah)ViewDataBinding.inflateInternal(layoutInflater, 2131558778, viewGroup, bl2, object);
    }

    public static ah z(LayoutInflater layoutInflater, Object object) {
        return (ah)ViewDataBinding.inflateInternal(layoutInflater, 2131558778, null, false, object);
    }

    public abstract void A(SplashFragment$c var1);

    public abstract void B(s var1);

    public SplashFragment$c u() {
        return this.m;
    }

    public s v() {
        return this.l;
    }
}

