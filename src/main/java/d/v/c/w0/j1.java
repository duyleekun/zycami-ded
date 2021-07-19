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

public abstract class j1
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public String c;
    public boolean d;

    public j1(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static j1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j1.t(view, dataBindingComponent);
    }

    public static j1 t(View view, Object object) {
        return (j1)ViewDataBinding.bind(object, view, 2131558471);
    }

    public static j1 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j1.y(layoutInflater, dataBindingComponent);
    }

    public static j1 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j1.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j1)ViewDataBinding.inflateInternal(layoutInflater, 2131558471, viewGroup, bl2, object);
    }

    public static j1 y(LayoutInflater layoutInflater, Object object) {
        return (j1)ViewDataBinding.inflateInternal(layoutInflater, 2131558471, null, false, object);
    }

    public abstract void A(boolean var1);

    public String getName() {
        return this.c;
    }

    public boolean u() {
        return this.d;
    }

    public abstract void z(String var1);
}

