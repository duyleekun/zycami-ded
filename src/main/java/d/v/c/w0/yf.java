/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.n1.j2;

public abstract class yf
extends ViewDataBinding {
    public final CheckBox a;
    public final ImageView b;
    public final TextView c;
    public j2 d;

    public yf(Object object, View view, int n10, CheckBox checkBox, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = imageView;
        this.c = textView;
    }

    public static yf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yf.t(view, dataBindingComponent);
    }

    public static yf t(View view, Object object) {
        return (yf)ViewDataBinding.bind(object, view, 2131558741);
    }

    public static yf v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yf.y(layoutInflater, dataBindingComponent);
    }

    public static yf w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yf.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yf x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yf)ViewDataBinding.inflateInternal(layoutInflater, 2131558741, viewGroup, bl2, object);
    }

    public static yf y(LayoutInflater layoutInflater, Object object) {
        return (yf)ViewDataBinding.inflateInternal(layoutInflater, 2131558741, null, false, object);
    }

    public j2 u() {
        return this.d;
    }

    public abstract void z(j2 var1);
}

