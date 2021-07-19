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
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment$b;
import com.zhiyun.cama.widget.MediaConstrainLayout;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.k1.a.w;

public abstract class v6
extends ViewDataBinding {
    public final Barrier a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final HorizontalScrollView d;
    public final ImageView e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final RecyclerView h;
    public final MediaConstrainLayout i;
    public final SwipeRefreshLayout j;
    public final StatusView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public AddVideoFragment$b p;
    public w q;
    public Integer r;
    public MediaType s;

    public v6(Object object, View view, int n10, Barrier barrier, FrameLayout frameLayout, FrameLayout frameLayout2, HorizontalScrollView horizontalScrollView, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, MediaConstrainLayout mediaConstrainLayout, SwipeRefreshLayout swipeRefreshLayout, StatusView statusView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = barrier;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = horizontalScrollView;
        this.e = imageView;
        this.f = linearLayout;
        this.g = recyclerView;
        this.h = recyclerView2;
        this.i = mediaConstrainLayout;
        this.j = swipeRefreshLayout;
        this.k = statusView;
        this.l = textView;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
    }

    public static v6 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v6)ViewDataBinding.inflateInternal(layoutInflater, 2131558572, viewGroup, bl2, object);
    }

    public static v6 B(LayoutInflater layoutInflater, Object object) {
        return (v6)ViewDataBinding.inflateInternal(layoutInflater, 2131558572, null, false, object);
    }

    public static v6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v6.t(view, dataBindingComponent);
    }

    public static v6 t(View view, Object object) {
        return (v6)ViewDataBinding.bind(object, view, 2131558572);
    }

    public static v6 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v6.B(layoutInflater, dataBindingComponent);
    }

    public static v6 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v6.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(AddVideoFragment$b var1);

    public abstract void D(Integer var1);

    public abstract void E(w var1);

    public abstract void F(MediaType var1);

    public AddVideoFragment$b u() {
        return this.p;
    }

    public Integer v() {
        return this.r;
    }

    public w w() {
        return this.q;
    }

    public MediaType x() {
        return this.s;
    }
}

