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

public abstract class yc
extends ViewDataBinding {
    public final RoundImageView a;

    public yc(Object object, View view, int n10, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = roundImageView;
    }

    public static yc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yc.t(view, dataBindingComponent);
    }

    public static yc t(View view, Object object) {
        return (yc)ViewDataBinding.bind(object, view, 2131558658);
    }

    public static yc u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yc.x(layoutInflater, dataBindingComponent);
    }

    public static yc v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yc.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yc w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yc)ViewDataBinding.inflateInternal(layoutInflater, 2131558658, viewGroup, bl2, object);
    }

    public static yc x(LayoutInflater layoutInflater, Object object) {
        return (yc)ViewDataBinding.inflateInternal(layoutInflater, 2131558658, null, false, object);
    }
}

