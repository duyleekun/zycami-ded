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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ag
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final View e;

    public ag(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = view2;
    }

    public static ag s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ag.t(view, dataBindingComponent);
    }

    public static ag t(View view, Object object) {
        return (ag)ViewDataBinding.bind(object, view, 2131558743);
    }

    public static ag u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ag.x(layoutInflater, dataBindingComponent);
    }

    public static ag v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ag.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ag w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ag)ViewDataBinding.inflateInternal(layoutInflater, 2131558743, viewGroup, bl2, object);
    }

    public static ag x(LayoutInflater layoutInflater, Object object) {
        return (ag)ViewDataBinding.inflateInternal(layoutInflater, 2131558743, null, false, object);
    }
}

