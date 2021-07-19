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

public abstract class id
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;

    public id(Object object, View view, int n10, ImageView imageView, ImageView imageView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
    }

    public static id s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return id.t(view, dataBindingComponent);
    }

    public static id t(View view, Object object) {
        return (id)ViewDataBinding.bind(object, view, 2131558669);
    }

    public static id u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return id.x(layoutInflater, dataBindingComponent);
    }

    public static id v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return id.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static id w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (id)ViewDataBinding.inflateInternal(layoutInflater, 2131558669, viewGroup, bl2, object);
    }

    public static id x(LayoutInflater layoutInflater, Object object) {
        return (id)ViewDataBinding.inflateInternal(layoutInflater, 2131558669, null, false, object);
    }
}

