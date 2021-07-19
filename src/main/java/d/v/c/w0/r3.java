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

public abstract class r3
extends ViewDataBinding {
    public final ImageView a;

    public r3(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static r3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r3.t(view, dataBindingComponent);
    }

    public static r3 t(View view, Object object) {
        return (r3)ViewDataBinding.bind(object, view, 2131558520);
    }

    public static r3 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r3.x(layoutInflater, dataBindingComponent);
    }

    public static r3 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r3.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r3)ViewDataBinding.inflateInternal(layoutInflater, 2131558520, viewGroup, bl2, object);
    }

    public static r3 x(LayoutInflater layoutInflater, Object object) {
        return (r3)ViewDataBinding.inflateInternal(layoutInflater, 2131558520, null, false, object);
    }
}

