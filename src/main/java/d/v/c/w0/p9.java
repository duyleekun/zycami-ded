/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.b1$b;

public abstract class p9
extends ViewDataBinding {
    public final ProgressBar a;
    public final ConstraintLayout b;
    public b1.b c;

    public p9(Object object, View view, int n10, ProgressBar progressBar, ConstraintLayout constraintLayout) {
        super(object, view, n10);
        this.a = progressBar;
        this.b = constraintLayout;
    }

    public static p9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p9.t(view, dataBindingComponent);
    }

    public static p9 t(View view, Object object) {
        return (p9)ViewDataBinding.bind(object, view, 2131558612);
    }

    public static p9 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p9.y(layoutInflater, dataBindingComponent);
    }

    public static p9 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p9.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p9)ViewDataBinding.inflateInternal(layoutInflater, 2131558612, viewGroup, bl2, object);
    }

    public static p9 y(LayoutInflater layoutInflater, Object object) {
        return (p9)ViewDataBinding.inflateInternal(layoutInflater, 2131558612, null, false, object);
    }

    public b1.b u() {
        return this.c;
    }

    public abstract void z(b1.b var1);
}

