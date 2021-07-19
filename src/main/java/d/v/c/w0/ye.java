/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ye
extends ViewDataBinding {
    public final ImageButton a;
    public final ImageView b;

    public ye(Object object, View view, int n10, ImageButton imageButton, ImageView imageView) {
        super(object, view, n10);
        this.a = imageButton;
        this.b = imageView;
    }

    public static ye s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ye.t(view, dataBindingComponent);
    }

    public static ye t(View view, Object object) {
        return (ye)ViewDataBinding.bind(object, view, 2131558701);
    }

    public static ye u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ye.x(layoutInflater, dataBindingComponent);
    }

    public static ye v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ye.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ye w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ye)ViewDataBinding.inflateInternal(layoutInflater, 2131558701, viewGroup, bl2, object);
    }

    public static ye x(LayoutInflater layoutInflater, Object object) {
        return (ye)ViewDataBinding.inflateInternal(layoutInflater, 2131558701, null, false, object);
    }
}

