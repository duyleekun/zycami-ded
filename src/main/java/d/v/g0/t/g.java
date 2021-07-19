/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;
import d.v.g0.i$a;
import d.v.g0.o;

public abstract class g
extends ViewDataBinding {
    public final TextView a;
    public o b;
    public Integer c;
    public i$a d;
    public Boolean e;

    public g(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static g A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.zyui_item_bottom_list;
        return (g)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static g B(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.zyui_item_bottom_list;
        return (g)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public static g s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.t(view, dataBindingComponent);
    }

    public static g t(View view, Object object) {
        int n10 = R$layout.zyui_item_bottom_list;
        return (g)ViewDataBinding.bind(object, view, n10);
    }

    public static g y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.B(layoutInflater, dataBindingComponent);
    }

    public static g z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(i$a var1);

    public abstract void D(Boolean var1);

    public abstract void E(o var1);

    public abstract void F(Integer var1);

    public i$a u() {
        return this.d;
    }

    public Boolean v() {
        return this.e;
    }

    public o w() {
        return this.b;
    }

    public Integer x() {
        return this.c;
    }
}

