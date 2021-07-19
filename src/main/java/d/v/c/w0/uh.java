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

public abstract class uh
extends ViewDataBinding {
    public final ImageView a;

    public uh(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static uh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uh.t(view, dataBindingComponent);
    }

    public static uh t(View view, Object object) {
        return (uh)ViewDataBinding.bind(object, view, 2131558788);
    }

    public static uh u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uh.x(layoutInflater, dataBindingComponent);
    }

    public static uh v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uh.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static uh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (uh)ViewDataBinding.inflateInternal(layoutInflater, 2131558788, viewGroup, bl2, object);
    }

    public static uh x(LayoutInflater layoutInflater, Object object) {
        return (uh)ViewDataBinding.inflateInternal(layoutInflater, 2131558788, null, false, object);
    }
}

