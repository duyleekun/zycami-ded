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

public abstract class z4
extends ViewDataBinding {
    public final ImageView a;

    public z4(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static z4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z4.t(view, dataBindingComponent);
    }

    public static z4 t(View view, Object object) {
        return (z4)ViewDataBinding.bind(object, view, 2131558537);
    }

    public static z4 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z4.x(layoutInflater, dataBindingComponent);
    }

    public static z4 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z4.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z4)ViewDataBinding.inflateInternal(layoutInflater, 2131558537, viewGroup, bl2, object);
    }

    public static z4 x(LayoutInflater layoutInflater, Object object) {
        return (z4)ViewDataBinding.inflateInternal(layoutInflater, 2131558537, null, false, object);
    }
}

