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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.EditorMainFragment$g;
import com.zhiyun.cama.widget.EditorHorizontalScrollView;
import com.zhiyun.cama.widget.EditorThumbnail;
import com.zhiyun.cama.widget.ScrollRecyclerViewImpl;
import d.v.c.i1.h2;
import d.v.c.i1.i2;
import d.v.c.w0.p4;
import d.v.c.w0.r4;
import d.v.c.w0.t4;
import d.v.c.w0.v4;

public abstract class t6
extends ViewDataBinding {
    public h2 A;
    public final HorizontalScrollView a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final ImageView e;
    public final FrameLayout f;
    public final LinearLayout g;
    public final ConstraintLayout h;
    public final LinearLayout i;
    public final View j;
    public final ScrollRecyclerViewImpl k;
    public final EditorHorizontalScrollView l;
    public final EditorThumbnail m;
    public final FrameLayout n;
    public final FrameLayout o;
    public final FrameLayout p;
    public final LinearLayout q;
    public final p4 r;
    public final r4 s;
    public final t4 t;
    public final v4 u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public i2 y;
    public EditorMainFragment$g z;

    public t6(Object object, View view, int n10, HorizontalScrollView horizontalScrollView, TextView textView, TextView textView2, LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, LinearLayout linearLayout3, View view2, ScrollRecyclerViewImpl scrollRecyclerViewImpl, EditorHorizontalScrollView editorHorizontalScrollView, EditorThumbnail editorThumbnail, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout4, p4 p42, r4 r42, t4 t42, v4 v42, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = horizontalScrollView;
        this.b = textView;
        this.c = textView2;
        this.d = linearLayout;
        this.e = imageView;
        this.f = frameLayout;
        this.g = linearLayout2;
        this.h = constraintLayout;
        this.i = linearLayout3;
        this.j = view2;
        this.k = scrollRecyclerViewImpl;
        this.l = editorHorizontalScrollView;
        this.m = editorThumbnail;
        this.n = frameLayout2;
        this.o = frameLayout3;
        this.p = frameLayout4;
        this.q = linearLayout4;
        this.r = p42;
        this.s = r42;
        this.t = t42;
        this.u = v42;
        this.v = textView3;
        this.w = textView4;
        this.x = textView5;
    }

    public static t6 A(LayoutInflater layoutInflater, Object object) {
        return (t6)ViewDataBinding.inflateInternal(layoutInflater, 2131558571, null, false, object);
    }

    public static t6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t6.t(view, dataBindingComponent);
    }

    public static t6 t(View view, Object object) {
        return (t6)ViewDataBinding.bind(object, view, 2131558571);
    }

    public static t6 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t6.A(layoutInflater, dataBindingComponent);
    }

    public static t6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t6.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t6 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t6)ViewDataBinding.inflateInternal(layoutInflater, 2131558571, viewGroup, bl2, object);
    }

    public abstract void B(EditorMainFragment$g var1);

    public abstract void C(h2 var1);

    public abstract void D(i2 var1);

    public EditorMainFragment$g u() {
        return this.z;
    }

    public h2 v() {
        return this.A;
    }

    public i2 w() {
        return this.y;
    }
}

