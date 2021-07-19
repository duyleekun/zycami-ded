/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class md
extends ViewDataBinding {
    public final EditText a;
    public final EditText b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final RelativeLayout i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public CameraFragment$j m;
    public z n;

    public md(Object object, View view, int n10, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout, TextView textView, TextView textView2, View view2) {
        super(object, view, n10);
        this.a = editText;
        this.b = editText2;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = relativeLayout;
        this.j = textView;
        this.k = textView2;
        this.l = view2;
    }

    public static md s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return md.t(view, dataBindingComponent);
    }

    public static md t(View view, Object object) {
        return (md)ViewDataBinding.bind(object, view, 2131558671);
    }

    public static md w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return md.z(layoutInflater, dataBindingComponent);
    }

    public static md x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return md.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static md y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (md)ViewDataBinding.inflateInternal(layoutInflater, 2131558671, viewGroup, bl2, object);
    }

    public static md z(LayoutInflater layoutInflater, Object object) {
        return (md)ViewDataBinding.inflateInternal(layoutInflater, 2131558671, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.m;
    }

    public z v() {
        return this.n;
    }
}

