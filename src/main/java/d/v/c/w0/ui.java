/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.q0.f.a;

public abstract class ui
extends ViewDataBinding {
    public final Button a;
    public final ImageView b;
    public final TextView c;
    public a d;

    public ui(Object object, View view, int n10, Button button, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = button;
        this.b = imageView;
        this.c = textView;
    }

    public static ui s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ui.t(view, dataBindingComponent);
    }

    public static ui t(View view, Object object) {
        return (ui)ViewDataBinding.bind(object, view, 2131558815);
    }

    public static ui v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ui.y(layoutInflater, dataBindingComponent);
    }

    public static ui w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ui.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ui x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ui)ViewDataBinding.inflateInternal(layoutInflater, 2131558815, viewGroup, bl2, object);
    }

    public static ui y(LayoutInflater layoutInflater, Object object) {
        return (ui)ViewDataBinding.inflateInternal(layoutInflater, 2131558815, null, false, object);
    }

    public a u() {
        return this.d;
    }

    public abstract void z(a var1);
}

