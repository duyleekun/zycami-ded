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

public abstract class uc
extends ViewDataBinding {
    public final RoundImageView a;
    public final ImageView b;
    public Integer c;
    public a d;
    public b e;

    public uc(Object object, View view, int n10, RoundImageView roundImageView, ImageView imageView) {
        super(object, view, n10);
        this.a = roundImageView;
        this.b = imageView;
    }

    public static uc A(LayoutInflater layoutInflater, Object object) {
        return (uc)ViewDataBinding.inflateInternal(layoutInflater, 2131558656, null, false, object);
    }

    public static uc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uc.t(view, dataBindingComponent);
    }

    public static uc t(View view, Object object) {
        return (uc)ViewDataBinding.bind(object, view, 2131558656);
    }

    public static uc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uc.A(layoutInflater, dataBindingComponent);
    }

    public static uc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static uc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (uc)ViewDataBinding.inflateInternal(layoutInflater, 2131558656, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(a var1);

    public abstract void D(b var1);

    public Integer u() {
        return this.c;
    }

    public a v() {
        return this.d;
    }

    public b w() {
        return this.e;
    }
}

