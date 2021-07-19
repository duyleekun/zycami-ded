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
import com.zhiyun.cama.zoom.EditorZoomFragment$a;
import d.v.c.c2.c;
import d.v.c.w0.b5;
import d.v.c.w0.j4;

public abstract class v8
extends ViewDataBinding {
    public final j4 a;
    public final b5 b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public EditorZoomFragment$a q;
    public c r;

    public v8(Object object, View view, int n10, j4 j42, b5 b52, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(object, view, n10);
        this.a = j42;
        this.b = b52;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = imageView7;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
    }

    public static v8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v8.t(view, dataBindingComponent);
    }

    public static v8 t(View view, Object object) {
        return (v8)ViewDataBinding.bind(object, view, 2131558598);
    }

    public static v8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v8.z(layoutInflater, dataBindingComponent);
    }

    public static v8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v8)ViewDataBinding.inflateInternal(layoutInflater, 2131558598, viewGroup, bl2, object);
    }

    public static v8 z(LayoutInflater layoutInflater, Object object) {
        return (v8)ViewDataBinding.inflateInternal(layoutInflater, 2131558598, null, false, object);
    }

    public abstract void A(EditorZoomFragment$a var1);

    public abstract void B(c var1);

    public EditorZoomFragment$a u() {
        return this.q;
    }

    public c v() {
        return this.r;
    }
}

