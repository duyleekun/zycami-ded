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
import com.zhiyun.account.me.account.widget.MePassView;
import com.zhiyun.account.set.privacy.SetNewPassFragment$a;
import d.v.a.j.c.y;

public abstract class k0
extends ViewDataBinding {
    public final ImageView a;
    public final MePassView b;
    public final MePassView c;
    public final TextView d;
    public final TextView e;
    public SetNewPassFragment$a f;
    public y g;

    public k0(Object object, View view, int n10, ImageView imageView, MePassView mePassView, MePassView mePassView2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = mePassView;
        this.c = mePassView2;
        this.d = textView;
        this.e = textView2;
    }

    public static k0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k0.t(view, dataBindingComponent);
    }

    public static k0 t(View view, Object object) {
        int n10 = R$layout.set_private_set_new_pass_frag;
        return (k0)ViewDataBinding.bind(object, view, n10);
    }

    public static k0 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k0.z(layoutInflater, dataBindingComponent);
    }

    public static k0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k0.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static k0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_set_new_pass_frag;
        return (k0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static k0 z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_set_new_pass_frag;
        return (k0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(SetNewPassFragment$a var1);

    public abstract void B(y var1);

    public SetNewPassFragment$a u() {
        return this.f;
    }

    public y v() {
        return this.g;
    }
}

