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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.y0.b.u.c$a;

public abstract class d4
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public c$a e;

    public d4(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    public static d4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d4.t(view, dataBindingComponent);
    }

    public static d4 t(View view, Object object) {
        return (d4)ViewDataBinding.bind(object, view, 2131558526);
    }

    public static d4 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d4.y(layoutInflater, dataBindingComponent);
    }

    public static d4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d4.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d4)ViewDataBinding.inflateInternal(layoutInflater, 2131558526, viewGroup, bl2, object);
    }

    public static d4 y(LayoutInflater layoutInflater, Object object) {
        return (d4)ViewDataBinding.inflateInternal(layoutInflater, 2131558526, null, false, object);
    }

    public c$a u() {
        return this.e;
    }

    public abstract void z(c$a var1);
}

