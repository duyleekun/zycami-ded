/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class x4
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;

    public x4(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static x4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x4.t(view, dataBindingComponent);
    }

    public static x4 t(View view, Object object) {
        return (x4)ViewDataBinding.bind(object, view, 2131558536);
    }

    public static x4 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x4.x(layoutInflater, dataBindingComponent);
    }

    public static x4 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x4.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x4)ViewDataBinding.inflateInternal(layoutInflater, 2131558536, viewGroup, bl2, object);
    }

    public static x4 x(LayoutInflater layoutInflater, Object object) {
        return (x4)ViewDataBinding.inflateInternal(layoutInflater, 2131558536, null, false, object);
    }
}

