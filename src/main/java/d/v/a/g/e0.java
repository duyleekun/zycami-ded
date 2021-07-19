/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.set.privacy.BindThirdFragment$b;
import com.zhiyun.account.widget.StatusView;
import d.v.a.j.c.y;

public abstract class e0
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final StatusView c;
    public final TextView d;
    public y e;
    public BindThirdFragment$b f;

    public e0(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = statusView;
        this.d = textView;
    }

    public static e0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return e0.t(view, dataBindingComponent);
    }

    public static e0 t(View view, Object object) {
        int n10 = R$layout.set_private_bind_third_frag;
        return (e0)ViewDataBinding.bind(object, view, n10);
    }

    public static e0 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return e0.z(layoutInflater, dataBindingComponent);
    }

    public static e0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return e0.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static e0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_bind_third_frag;
        return (e0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static e0 z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_bind_third_frag;
        return (e0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(BindThirdFragment$b var1);

    public abstract void B(y var1);

    public BindThirdFragment$b u() {
        return this.f;
    }

    public y v() {
        return this.e;
    }
}

