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
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.y1.f.x.g0$a;
import d.v.c.y1.f.x.l0;

public abstract class f7
extends ViewDataBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;
    public g0$a e;
    public l0 f;

    public f7(Object object, View view, int n10, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
    }

    public static f7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f7.t(view, dataBindingComponent);
    }

    public static f7 t(View view, Object object) {
        return (f7)ViewDataBinding.bind(object, view, 2131558577);
    }

    public static f7 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f7.z(layoutInflater, dataBindingComponent);
    }

    public static f7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f7.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f7)ViewDataBinding.inflateInternal(layoutInflater, 2131558577, viewGroup, bl2, object);
    }

    public static f7 z(LayoutInflater layoutInflater, Object object) {
        return (f7)ViewDataBinding.inflateInternal(layoutInflater, 2131558577, null, false, object);
    }

    public abstract void A(g0$a var1);

    public abstract void B(l0 var1);

    public g0$a u() {
        return this.e;
    }

    public l0 v() {
        return this.f;
    }
}

