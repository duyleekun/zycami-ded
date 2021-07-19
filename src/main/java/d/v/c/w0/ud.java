/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class ud
extends ViewDataBinding {
    public final CheckBox a;
    public final ImageView b;
    public final CheckBox c;
    public final CheckBox d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final RecyclerView i;
    public final RecyclerView j;
    public final RelativeLayout k;
    public final RelativeLayout l;
    public final RelativeLayout m;
    public final RelativeLayout n;
    public final RelativeLayout o;
    public final ScrollView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final View w;
    public CameraFragment$j x;
    public z y;

    public ud(Object object, View view, int n10, CheckBox checkBox, ImageView imageView, CheckBox checkBox2, CheckBox checkBox3, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RecyclerView recyclerView, RecyclerView recyclerView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = imageView;
        this.c = checkBox2;
        this.d = checkBox3;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = recyclerView;
        this.j = recyclerView2;
        this.k = relativeLayout;
        this.l = relativeLayout2;
        this.m = relativeLayout3;
        this.n = relativeLayout4;
        this.o = relativeLayout5;
        this.p = scrollView;
        this.q = textView;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = view2;
    }

    public static ud s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ud.t(view, dataBindingComponent);
    }

    public static ud t(View view, Object object) {
        return (ud)ViewDataBinding.bind(object, view, 2131558675);
    }

    public static ud w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ud.z(layoutInflater, dataBindingComponent);
    }

    public static ud x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ud.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ud y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ud)ViewDataBinding.inflateInternal(layoutInflater, 2131558675, viewGroup, bl2, object);
    }

    public static ud z(LayoutInflater layoutInflater, Object object) {
        return (ud)ViewDataBinding.inflateInternal(layoutInflater, 2131558675, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.x;
    }

    public z v() {
        return this.y;
    }
}

