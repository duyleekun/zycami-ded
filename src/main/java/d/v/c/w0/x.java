/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.album.AlbumListFragment$a;
import d.v.c.o0.u0;

public abstract class x
extends ViewDataBinding {
    public final ImageButton a;
    public final TextView b;
    public final ImageView c;
    public final ImageButton d;
    public final TextView e;
    public final Group f;
    public final HorizontalScrollView g;
    public final ProgressBar h;
    public final TextView i;
    public final RecyclerView j;
    public final TextView k;
    public final TextView l;
    public u0 m;
    public ObservableInt n;
    public ObservableBoolean o;
    public AlbumListFragment.a p;

    public x(Object object, View view, int n10, ImageButton imageButton, TextView textView, ImageView imageView, ImageButton imageButton2, TextView textView2, Group group, HorizontalScrollView horizontalScrollView, ProgressBar progressBar, TextView textView3, RecyclerView recyclerView, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = imageButton;
        this.b = textView;
        this.c = imageView;
        this.d = imageButton2;
        this.e = textView2;
        this.f = group;
        this.g = horizontalScrollView;
        this.h = progressBar;
        this.i = textView3;
        this.j = recyclerView;
        this.k = textView4;
        this.l = textView5;
    }

    public static x A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x)ViewDataBinding.inflateInternal(layoutInflater, 2131558449, viewGroup, bl2, object);
    }

    public static x B(LayoutInflater layoutInflater, Object object) {
        return (x)ViewDataBinding.inflateInternal(layoutInflater, 2131558449, null, false, object);
    }

    public static x s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x.t(view, dataBindingComponent);
    }

    public static x t(View view, Object object) {
        return (x)ViewDataBinding.bind(object, view, 2131558449);
    }

    public static x y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x.B(layoutInflater, dataBindingComponent);
    }

    public static x z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(AlbumListFragment.a var1);

    public abstract void D(ObservableBoolean var1);

    public abstract void E(ObservableInt var1);

    public abstract void F(u0 var1);

    public AlbumListFragment.a u() {
        return this.p;
    }

    public ObservableBoolean v() {
        return this.o;
    }

    public ObservableInt w() {
        return this.n;
    }

    public u0 x() {
        return this.m;
    }
}

