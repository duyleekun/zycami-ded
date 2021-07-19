/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;

public abstract class q
extends ViewDataBinding {
    public final TextView a;
    public final View b;
    public String c;
    public int d;
    public boolean e;

    public q(Object object, View view, int n10, TextView textView, View view2) {
        super(object, view, n10);
        this.a = textView;
        this.b = view2;
    }

    public static q A(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_country_head_item;
        return (q)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public static q s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return q.t(view, dataBindingComponent);
    }

    public static q t(View view, Object object) {
        int n10 = R$layout.me_country_head_item;
        return (q)ViewDataBinding.bind(object, view, n10);
    }

    public static q x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return q.A(layoutInflater, dataBindingComponent);
    }

    public static q y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return q.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static q z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_country_head_item;
        return (q)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public abstract void B(String var1);

    public abstract void C(int var1);

    public abstract void D(boolean var1);

    public String u() {
        return this.c;
    }

    public int v() {
        return this.d;
    }

    public boolean w() {
        return this.e;
    }
}

