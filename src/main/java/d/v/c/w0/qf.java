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

public abstract class qf
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public String d;

    public qf(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static qf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qf.t(view, dataBindingComponent);
    }

    public static qf t(View view, Object object) {
        return (qf)ViewDataBinding.bind(object, view, 2131558714);
    }

    public static qf v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qf.y(layoutInflater, dataBindingComponent);
    }

    public static qf w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qf.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qf x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qf)ViewDataBinding.inflateInternal(layoutInflater, 2131558714, viewGroup, bl2, object);
    }

    public static qf y(LayoutInflater layoutInflater, Object object) {
        return (qf)ViewDataBinding.inflateInternal(layoutInflater, 2131558714, null, false, object);
    }

    public String u() {
        return this.d;
    }

    public abstract void z(String var1);
}

