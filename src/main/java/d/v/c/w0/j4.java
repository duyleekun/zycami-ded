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
import d.v.c.q0.f.a;

public abstract class j4
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public a c;

    public j4(Object object, View view, int n10, ImageView imageView, ImageView imageView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
    }

    public static j4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j4.t(view, dataBindingComponent);
    }

    public static j4 t(View view, Object object) {
        return (j4)ViewDataBinding.bind(object, view, 2131558529);
    }

    public static j4 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j4.y(layoutInflater, dataBindingComponent);
    }

    public static j4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j4.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j4)ViewDataBinding.inflateInternal(layoutInflater, 2131558529, viewGroup, bl2, object);
    }

    public static j4 y(LayoutInflater layoutInflater, Object object) {
        return (j4)ViewDataBinding.inflateInternal(layoutInflater, 2131558529, null, false, object);
    }

    public a u() {
        return this.c;
    }

    public abstract void z(a var1);
}

