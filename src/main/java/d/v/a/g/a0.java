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
import com.zhiyun.account.set.privacy.PrivateBindFragment$a;

public abstract class a0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public PrivateBindFragment$a c;

    public a0(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static a0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return a0.t(view, dataBindingComponent);
    }

    public static a0 t(View view, Object object) {
        int n10 = R$layout.set_private_bind_frag;
        return (a0)ViewDataBinding.bind(object, view, n10);
    }

    public static a0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return a0.y(layoutInflater, dataBindingComponent);
    }

    public static a0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return a0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static a0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_bind_frag;
        return (a0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static a0 y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_bind_frag;
        return (a0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public PrivateBindFragment$a u() {
        return this.c;
    }

    public abstract void z(PrivateBindFragment$a var1);
}

