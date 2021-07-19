/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.k1.a.w;
import d.v.h.e.a;

public abstract class ob
extends ViewDataBinding {
    public final RoundImageView a;
    public ObservableBoolean b;
    public ObservableInt c;
    public Integer d;
    public a e;
    public w f;
    public Boolean g;

    public ob(Object object, View view, int n10, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = roundImageView;
    }

    public static ob A(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ob.D(layoutInflater, dataBindingComponent);
    }

    public static ob B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ob.C(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ob C(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ob)ViewDataBinding.inflateInternal(layoutInflater, 2131558638, viewGroup, bl2, object);
    }

    public static ob D(LayoutInflater layoutInflater, Object object) {
        return (ob)ViewDataBinding.inflateInternal(layoutInflater, 2131558638, null, false, object);
    }

    public static ob s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ob.t(view, dataBindingComponent);
    }

    public static ob t(View view, Object object) {
        return (ob)ViewDataBinding.bind(object, view, 2131558638);
    }

    public abstract void E(ObservableBoolean var1);

    public abstract void F(Boolean var1);

    public abstract void G(a var1);

    public abstract void H(Integer var1);

    public abstract void I(ObservableInt var1);

    public abstract void J(w var1);

    public ObservableBoolean u() {
        return this.b;
    }

    public Boolean v() {
        return this.g;
    }

    public a w() {
        return this.e;
    }

    public Integer x() {
        return this.d;
    }

    public ObservableInt y() {
        return this.c;
    }

    public w z() {
        return this.f;
    }
}

