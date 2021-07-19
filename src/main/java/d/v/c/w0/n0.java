/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.w0$a;

public abstract class n0
extends ViewDataBinding {
    public final ImageView a;
    public int b;
    public Drawable c;
    public w0$a d;

    public n0(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static n0 A(LayoutInflater layoutInflater, Object object) {
        return (n0)ViewDataBinding.inflateInternal(layoutInflater, 2131558460, null, false, object);
    }

    public static n0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n0.t(view, dataBindingComponent);
    }

    public static n0 t(View view, Object object) {
        return (n0)ViewDataBinding.bind(object, view, 2131558460);
    }

    public static n0 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n0.A(layoutInflater, dataBindingComponent);
    }

    public static n0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n0.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n0 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n0)ViewDataBinding.inflateInternal(layoutInflater, 2131558460, viewGroup, bl2, object);
    }

    public abstract void B(w0$a var1);

    public abstract void C(Drawable var1);

    public abstract void D(int var1);

    public w0$a u() {
        return this.d;
    }

    public Drawable v() {
        return this.c;
    }

    public int w() {
        return this.b;
    }
}

