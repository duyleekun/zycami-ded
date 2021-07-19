/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class mh
extends ViewDataBinding {
    public final View a;

    public mh(Object object, View view, int n10, View view2) {
        super(object, view, n10);
        this.a = view2;
    }

    public static mh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mh.t(view, dataBindingComponent);
    }

    public static mh t(View view, Object object) {
        return (mh)ViewDataBinding.bind(object, view, 2131558784);
    }

    public static mh u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mh.x(layoutInflater, dataBindingComponent);
    }

    public static mh v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mh.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mh)ViewDataBinding.inflateInternal(layoutInflater, 2131558784, viewGroup, bl2, object);
    }

    public static mh x(LayoutInflater layoutInflater, Object object) {
        return (mh)ViewDataBinding.inflateInternal(layoutInflater, 2131558784, null, false, object);
    }
}

