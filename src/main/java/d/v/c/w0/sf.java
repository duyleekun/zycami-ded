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
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.q0.f.a;

public abstract class sf
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ZYTextView c;
    public final ZYTextView d;
    public MutableLiveData e;
    public MutableLiveData f;
    public MutableLiveData g;
    public MutableLiveData h;
    public a i;

    public sf(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ZYTextView zYTextView, ZYTextView zYTextView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = zYTextView;
        this.d = zYTextView2;
    }

    public static sf A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sf.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sf B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sf)ViewDataBinding.inflateInternal(layoutInflater, 2131558715, viewGroup, bl2, object);
    }

    public static sf C(LayoutInflater layoutInflater, Object object) {
        return (sf)ViewDataBinding.inflateInternal(layoutInflater, 2131558715, null, false, object);
    }

    public static sf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sf.t(view, dataBindingComponent);
    }

    public static sf t(View view, Object object) {
        return (sf)ViewDataBinding.bind(object, view, 2131558715);
    }

    public static sf z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sf.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(MutableLiveData var1);

    public abstract void E(MutableLiveData var1);

    public abstract void F(a var1);

    public abstract void G(MutableLiveData var1);

    public abstract void H(MutableLiveData var1);

    public MutableLiveData u() {
        return this.h;
    }

    public MutableLiveData v() {
        return this.g;
    }

    public a w() {
        return this.i;
    }

    public MutableLiveData x() {
        return this.e;
    }

    public MutableLiveData y() {
        return this.f;
    }
}

