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
import androidx.viewpager.widget.ViewPager;

public abstract class sh
extends ViewDataBinding {
    public final ViewPager a;

    public sh(Object object, View view, int n10, ViewPager viewPager) {
        super(object, view, n10);
        this.a = viewPager;
    }

    public static sh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sh.t(view, dataBindingComponent);
    }

    public static sh t(View view, Object object) {
        return (sh)ViewDataBinding.bind(object, view, 2131558787);
    }

    public static sh u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sh.x(layoutInflater, dataBindingComponent);
    }

    public static sh v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sh.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sh)ViewDataBinding.inflateInternal(layoutInflater, 2131558787, viewGroup, bl2, object);
    }

    public static sh x(LayoutInflater layoutInflater, Object object) {
        return (sh)ViewDataBinding.inflateInternal(layoutInflater, 2131558787, null, false, object);
    }
}

