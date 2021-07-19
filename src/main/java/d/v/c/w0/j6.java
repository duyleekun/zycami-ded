/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.n1.l2;
import d.v.c.y1.h.h$a;

public abstract class j6
extends ViewDataBinding {
    public final ImageView a;
    public final ProgressBar b;
    public final RecyclerView c;
    public l2 d;
    public h$a e;

    public j6(Object object, View view, int n10, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = progressBar;
        this.c = recyclerView;
    }

    public static j6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j6.t(view, dataBindingComponent);
    }

    public static j6 t(View view, Object object) {
        return (j6)ViewDataBinding.bind(object, view, 2131558566);
    }

    public static j6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j6.z(layoutInflater, dataBindingComponent);
    }

    public static j6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j6)ViewDataBinding.inflateInternal(layoutInflater, 2131558566, viewGroup, bl2, object);
    }

    public static j6 z(LayoutInflater layoutInflater, Object object) {
        return (j6)ViewDataBinding.inflateInternal(layoutInflater, 2131558566, null, false, object);
    }

    public abstract void A(h$a var1);

    public abstract void B(l2 var1);

    public h$a u() {
        return this.e;
    }

    public l2 v() {
        return this.d;
    }
}

