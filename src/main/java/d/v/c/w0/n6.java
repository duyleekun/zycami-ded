/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.y1.h.i$a;
import d.v.c.y1.h.j;

public abstract class n6
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ExoVideoView c;
    public final ImageView d;
    public final LineProgressBar e;
    public final LineProgressBar f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ImageButton k;
    public i$a l;
    public j m;

    public n6(Object object, View view, int n10, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ExoVideoView exoVideoView, ImageView imageView, LineProgressBar lineProgressBar, LineProgressBar lineProgressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageButton imageButton) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = exoVideoView;
        this.d = imageView;
        this.e = lineProgressBar;
        this.f = lineProgressBar2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = imageButton;
    }

    public static n6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n6.t(view, dataBindingComponent);
    }

    public static n6 t(View view, Object object) {
        return (n6)ViewDataBinding.bind(object, view, 2131558568);
    }

    public static n6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n6.z(layoutInflater, dataBindingComponent);
    }

    public static n6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n6)ViewDataBinding.inflateInternal(layoutInflater, 2131558568, viewGroup, bl2, object);
    }

    public static n6 z(LayoutInflater layoutInflater, Object object) {
        return (n6)ViewDataBinding.inflateInternal(layoutInflater, 2131558568, null, false, object);
    }

    public abstract void A(i$a var1);

    public abstract void B(j var1);

    public i$a u() {
        return this.l;
    }

    public j v() {
        return this.m;
    }
}

