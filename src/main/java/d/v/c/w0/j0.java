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
import com.zhiyun.cama.camera.data.BeautyData;
import d.v.c.s0.a7.v0$c;

public abstract class j0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public int c;
    public BeautyData d;
    public v0.c e;
    public boolean f;

    public j0(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static j0 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j0)ViewDataBinding.inflateInternal(layoutInflater, 2131558458, viewGroup, bl2, object);
    }

    public static j0 B(LayoutInflater layoutInflater, Object object) {
        return (j0)ViewDataBinding.inflateInternal(layoutInflater, 2131558458, null, false, object);
    }

    public static j0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j0.t(view, dataBindingComponent);
    }

    public static j0 t(View view, Object object) {
        return (j0)ViewDataBinding.bind(object, view, 2131558458);
    }

    public static j0 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j0.B(layoutInflater, dataBindingComponent);
    }

    public static j0 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j0.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(BeautyData var1);

    public abstract void D(v0.c var1);

    public abstract void E(int var1);

    public abstract void F(boolean var1);

    public BeautyData u() {
        return this.d;
    }

    public v0.c v() {
        return this.e;
    }

    public int w() {
        return this.c;
    }

    public boolean x() {
        return this.f;
    }
}

