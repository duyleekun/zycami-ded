/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.z0.j$a;

public abstract class f4
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public j$a f;

    public f4(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
    }

    public static f4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f4.t(view, dataBindingComponent);
    }

    public static f4 t(View view, Object object) {
        return (f4)ViewDataBinding.bind(object, view, 2131558527);
    }

    public static f4 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f4.y(layoutInflater, dataBindingComponent);
    }

    public static f4 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f4.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f4)ViewDataBinding.inflateInternal(layoutInflater, 2131558527, viewGroup, bl2, object);
    }

    public static f4 y(LayoutInflater layoutInflater, Object object) {
        return (f4)ViewDataBinding.inflateInternal(layoutInflater, 2131558527, null, false, object);
    }

    public j$a u() {
        return this.f;
    }

    public abstract void z(j$a var1);
}

