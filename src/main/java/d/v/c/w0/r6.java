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
import com.zhiyun.cama.effect.EditorFrameFragment$a;
import com.zhiyun.cama.widget.DoubleSeekBar;
import d.v.c.c1.d;
import d.v.c.w0.b5;
import d.v.c.w0.j4;

public abstract class r6
extends ViewDataBinding {
    public final j4 a;
    public final b5 b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final DoubleSeekBar h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public d n;
    public EditorFrameFragment$a o;

    public r6(Object object, View view, int n10, j4 j42, b5 b52, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, DoubleSeekBar doubleSeekBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = j42;
        this.b = b52;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = doubleSeekBar;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
    }

    public static r6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r6.t(view, dataBindingComponent);
    }

    public static r6 t(View view, Object object) {
        return (r6)ViewDataBinding.bind(object, view, 2131558570);
    }

    public static r6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r6.z(layoutInflater, dataBindingComponent);
    }

    public static r6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r6)ViewDataBinding.inflateInternal(layoutInflater, 2131558570, viewGroup, bl2, object);
    }

    public static r6 z(LayoutInflater layoutInflater, Object object) {
        return (r6)ViewDataBinding.inflateInternal(layoutInflater, 2131558570, null, false, object);
    }

    public abstract void A(EditorFrameFragment$a var1);

    public abstract void B(d var1);

    public EditorFrameFragment$a u() {
        return this.o;
    }

    public d v() {
        return this.n;
    }
}

