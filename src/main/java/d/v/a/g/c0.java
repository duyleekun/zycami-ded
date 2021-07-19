/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.set.privacy.BindSuccessFragment$a;
import d.v.a.j.c.y;

public abstract class c0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public y c;
    public BindSuccessFragment$a d;

    public c0(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static c0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return c0.t(view, dataBindingComponent);
    }

    public static c0 t(View view, Object object) {
        int n10 = R$layout.set_private_bind_success_frag;
        return (c0)ViewDataBinding.bind(object, view, n10);
    }

    public static c0 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return c0.z(layoutInflater, dataBindingComponent);
    }

    public static c0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return c0.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static c0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_bind_success_frag;
        return (c0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static c0 z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_bind_success_frag;
        return (c0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(BindSuccessFragment$a var1);

    public abstract void B(y var1);

    public BindSuccessFragment$a u() {
        return this.d;
    }

    public y v() {
        return this.c;
    }
}

