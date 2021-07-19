/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.widget.WheelPicker;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.a7.e1$d;

public abstract class h1
extends ViewDataBinding {
    public final CardView a;
    public final ExoVideoView b;
    public final FrameLayout c;
    public final ImageView d;
    public final LinearLayout e;
    public final HorizontalScrollView f;
    public final View g;
    public final View h;
    public final WheelPicker i;
    public final WheelPicker j;
    public e1.d k;
    public Integer l;

    public h1(Object object, View view, int n10, CardView cardView, ExoVideoView exoVideoView, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView, View view2, View view3, WheelPicker wheelPicker, WheelPicker wheelPicker2) {
        super(object, view, n10);
        this.a = cardView;
        this.b = exoVideoView;
        this.c = frameLayout;
        this.d = imageView;
        this.e = linearLayout;
        this.f = horizontalScrollView;
        this.g = view2;
        this.h = view3;
        this.i = wheelPicker;
        this.j = wheelPicker2;
    }

    public static h1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h1.t(view, dataBindingComponent);
    }

    public static h1 t(View view, Object object) {
        return (h1)ViewDataBinding.bind(object, view, 2131558470);
    }

    public static h1 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h1.z(layoutInflater, dataBindingComponent);
    }

    public static h1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h1.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h1)ViewDataBinding.inflateInternal(layoutInflater, 2131558470, viewGroup, bl2, object);
    }

    public static h1 z(LayoutInflater layoutInflater, Object object) {
        return (h1)ViewDataBinding.inflateInternal(layoutInflater, 2131558470, null, false, object);
    }

    public abstract void A(e1.d var1);

    public abstract void B(Integer var1);

    public e1.d u() {
        return this.k;
    }

    public Integer v() {
        return this.l;
    }
}

