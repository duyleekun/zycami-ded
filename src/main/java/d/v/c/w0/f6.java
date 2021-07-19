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
import d.v.c.y1.d$a;

public abstract class f6
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public d$a e;

    public f6(Object object, View view, int n10, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
        this.d = textView2;
    }

    public static f6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f6.t(view, dataBindingComponent);
    }

    public static f6 t(View view, Object object) {
        return (f6)ViewDataBinding.bind(object, view, 2131558564);
    }

    public static f6 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f6.y(layoutInflater, dataBindingComponent);
    }

    public static f6 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f6.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f6)ViewDataBinding.inflateInternal(layoutInflater, 2131558564, viewGroup, bl2, object);
    }

    public static f6 y(LayoutInflater layoutInflater, Object object) {
        return (f6)ViewDataBinding.inflateInternal(layoutInflater, 2131558564, null, false, object);
    }

    public d$a u() {
        return this.e;
    }

    public abstract void z(d$a var1);
}

