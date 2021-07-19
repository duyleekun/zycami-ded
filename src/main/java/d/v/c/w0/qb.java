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
import d.v.c.k1.a.w;
import d.v.h.e.a;

public abstract class qb
extends ViewDataBinding {
    public final ImageView a;
    public a b;
    public w c;

    public qb(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static qb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qb.t(view, dataBindingComponent);
    }

    public static qb t(View view, Object object) {
        return (qb)ViewDataBinding.bind(object, view, 2131558639);
    }

    public static qb w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qb.z(layoutInflater, dataBindingComponent);
    }

    public static qb x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qb.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qb y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qb)ViewDataBinding.inflateInternal(layoutInflater, 2131558639, viewGroup, bl2, object);
    }

    public static qb z(LayoutInflater layoutInflater, Object object) {
        return (qb)ViewDataBinding.inflateInternal(layoutInflater, 2131558639, null, false, object);
    }

    public abstract void A(a var1);

    public abstract void B(w var1);

    public a u() {
        return this.b;
    }

    public w v() {
        return this.c;
    }
}

