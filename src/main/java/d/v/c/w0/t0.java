/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import d.v.c.s0.a7.a1$a;

public abstract class t0
extends ViewDataBinding {
    public final ImageButton a;
    public final ViewPager b;
    public a1.a c;

    public t0(Object object, View view, int n10, ImageButton imageButton, ViewPager viewPager) {
        super(object, view, n10);
        this.a = imageButton;
        this.b = viewPager;
    }

    public static t0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t0.t(view, dataBindingComponent);
    }

    public static t0 t(View view, Object object) {
        return (t0)ViewDataBinding.bind(object, view, 2131558463);
    }

    public static t0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t0.y(layoutInflater, dataBindingComponent);
    }

    public static t0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t0)ViewDataBinding.inflateInternal(layoutInflater, 2131558463, viewGroup, bl2, object);
    }

    public static t0 y(LayoutInflater layoutInflater, Object object) {
        return (t0)ViewDataBinding.inflateInternal(layoutInflater, 2131558463, null, false, object);
    }

    public a1.a u() {
        return this.c;
    }

    public abstract void z(a1.a var1);
}

