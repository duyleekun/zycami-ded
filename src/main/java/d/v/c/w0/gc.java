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

public abstract class gc
extends ViewDataBinding {
    public final ImageView a;
    public final RoundImageView b;
    public a c;
    public b d;
    public Integer e;

    public gc(Object object, View view, int n10, ImageView imageView, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = roundImageView;
    }

    public static gc A(LayoutInflater layoutInflater, Object object) {
        return (gc)ViewDataBinding.inflateInternal(layoutInflater, 2131558647, null, false, object);
    }

    public static gc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gc.t(view, dataBindingComponent);
    }

    public static gc t(View view, Object object) {
        return (gc)ViewDataBinding.bind(object, view, 2131558647);
    }

    public static gc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gc.A(layoutInflater, dataBindingComponent);
    }

    public static gc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gc)ViewDataBinding.inflateInternal(layoutInflater, 2131558647, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(a var1);

    public abstract void D(b var1);

    public Integer u() {
        return this.e;
    }

    public a v() {
        return this.c;
    }

    public b w() {
        return this.d;
    }
}

