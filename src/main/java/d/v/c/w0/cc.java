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
import d.v.c.r1.d;

public abstract class cc
extends ViewDataBinding {
    public final RoundImageView a;
    public d b;

    public cc(Object object, View view, int n10, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = roundImageView;
    }

    public static cc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cc.t(view, dataBindingComponent);
    }

    public static cc t(View view, Object object) {
        return (cc)ViewDataBinding.bind(object, view, 2131558645);
    }

    public static cc v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cc.y(layoutInflater, dataBindingComponent);
    }

    public static cc w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cc.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static cc x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (cc)ViewDataBinding.inflateInternal(layoutInflater, 2131558645, viewGroup, bl2, object);
    }

    public static cc y(LayoutInflater layoutInflater, Object object) {
        return (cc)ViewDataBinding.inflateInternal(layoutInflater, 2131558645, null, false, object);
    }

    public d u() {
        return this.b;
    }

    public abstract void z(d var1);
}

