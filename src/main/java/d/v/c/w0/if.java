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

public abstract class if
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public String f;
    public String g;
    public int h;

    public if(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = textView;
        this.e = textView2;
    }

    public static if s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return if.t(view, dataBindingComponent);
    }

    public static if t(View view, Object object) {
        return (if)ViewDataBinding.bind(object, view, 2131558707);
    }

    public static if w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return if.z(layoutInflater, dataBindingComponent);
    }

    public static if x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return if.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static if y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (if)ViewDataBinding.inflateInternal(layoutInflater, 2131558707, viewGroup, bl2, object);
    }

    public static if z(LayoutInflater layoutInflater, Object object) {
        return (if)ViewDataBinding.inflateInternal(layoutInflater, 2131558707, null, false, object);
    }

    public abstract void A(String var1);

    public abstract void B(int var1);

    public abstract void C(String var1);

    public String getName() {
        return this.f;
    }

    public int u() {
        return this.h;
    }

    public String v() {
        return this.g;
    }
}

