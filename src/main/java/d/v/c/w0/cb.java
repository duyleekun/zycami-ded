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
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.w.j;

public abstract class cb
extends ViewDataBinding {
    public final RoundImageView a;
    public j b;

    public cb(Object object, View view, int n10, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = roundImageView;
    }

    public static cb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cb.t(view, dataBindingComponent);
    }

    public static cb t(View view, Object object) {
        return (cb)ViewDataBinding.bind(object, view, 2131558632);
    }

    public static cb v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cb.y(layoutInflater, dataBindingComponent);
    }

    public static cb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cb.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static cb x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (cb)ViewDataBinding.inflateInternal(layoutInflater, 2131558632, viewGroup, bl2, object);
    }

    public static cb y(LayoutInflater layoutInflater, Object object) {
        return (cb)ViewDataBinding.inflateInternal(layoutInflater, 2131558632, null, false, object);
    }

    public j u() {
        return this.b;
    }

    public abstract void z(j var1);
}

