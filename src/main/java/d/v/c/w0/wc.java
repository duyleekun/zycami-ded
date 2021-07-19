/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.v.b;
import d.v.c.b2.w.a;

public abstract class wc
extends ViewDataBinding {
    public final ImageView a;
    public final RoundImageView b;
    public a c;
    public Integer d;
    public b e;

    public wc(Object object, View view, int n10, ImageView imageView, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = roundImageView;
    }

    public static wc A(LayoutInflater layoutInflater, Object object) {
        return (wc)ViewDataBinding.inflateInternal(layoutInflater, 2131558657, null, false, object);
    }

    public static wc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wc.t(view, dataBindingComponent);
    }

    public static wc t(View view, Object object) {
        return (wc)ViewDataBinding.bind(object, view, 2131558657);
    }

    public static wc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wc.A(layoutInflater, dataBindingComponent);
    }

    public static wc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wc)ViewDataBinding.inflateInternal(layoutInflater, 2131558657, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(a var1);

    public abstract void D(b var1);

    public Integer u() {
        return this.d;
    }

    public a v() {
        return this.c;
    }

    public b w() {
        return this.e;
    }
}

