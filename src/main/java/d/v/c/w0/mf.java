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

public abstract class mf
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public String e;
    public String f;
    public int g;
    public boolean h;
    public String i;
    public boolean j;

    public mf(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static mf A(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mf.D(layoutInflater, dataBindingComponent);
    }

    public static mf B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mf.C(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mf C(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mf)ViewDataBinding.inflateInternal(layoutInflater, 2131558709, viewGroup, bl2, object);
    }

    public static mf D(LayoutInflater layoutInflater, Object object) {
        return (mf)ViewDataBinding.inflateInternal(layoutInflater, 2131558709, null, false, object);
    }

    public static mf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mf.t(view, dataBindingComponent);
    }

    public static mf t(View view, Object object) {
        return (mf)ViewDataBinding.bind(object, view, 2131558709);
    }

    public abstract void E(boolean var1);

    public abstract void F(String var1);

    public abstract void G(String var1);

    public abstract void H(int var1);

    public abstract void I(boolean var1);

    public abstract void J(String var1);

    public boolean u() {
        return this.h;
    }

    public String v() {
        return this.i;
    }

    public String w() {
        return this.e;
    }

    public int x() {
        return this.g;
    }

    public boolean y() {
        return this.j;
    }

    public String z() {
        return this.f;
    }
}

