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
import androidx.fragment.app.FragmentContainerView;

public abstract class t
extends ViewDataBinding {
    public final FragmentContainerView a;

    public t(Object object, View view, int n10, FragmentContainerView fragmentContainerView) {
        super(object, view, n10);
        this.a = fragmentContainerView;
    }

    public static t s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t.t(view, dataBindingComponent);
    }

    public static t t(View view, Object object) {
        return (t)ViewDataBinding.bind(object, view, 2131558446);
    }

    public static t u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t.x(layoutInflater, dataBindingComponent);
    }

    public static t v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t)ViewDataBinding.inflateInternal(layoutInflater, 2131558446, viewGroup, bl2, object);
    }

    public static t x(LayoutInflater layoutInflater, Object object) {
        return (t)ViewDataBinding.inflateInternal(layoutInflater, 2131558446, null, false, object);
    }
}

