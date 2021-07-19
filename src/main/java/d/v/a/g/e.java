/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.LoginFragment$a;
import com.zhiyun.account.me.account.widget.MeNameView;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.i.a.m0;

public abstract class e
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final ImageView c;
    public final ImageView d;
    public final MeNameView e;
    public final MePassView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public LoginFragment$a k;
    public m0 l;

    public e(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, ImageView imageView, ImageView imageView2, MeNameView meNameView, MePassView mePassView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = imageView;
        this.d = imageView2;
        this.e = meNameView;
        this.f = mePassView;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
    }

    public static e s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.e.t(view, dataBindingComponent);
    }

    public static e t(View view, Object object) {
        int n10 = R$layout.me_account_login_frag;
        return (e)ViewDataBinding.bind(object, view, n10);
    }

    public static e w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.e.z(layoutInflater, dataBindingComponent);
    }

    public static e x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.e.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static e y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_account_login_frag;
        return (e)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static e z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_account_login_frag;
        return (e)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(LoginFragment$a var1);

    public abstract void B(m0 var1);

    public LoginFragment$a u() {
        return this.k;
    }

    public m0 v() {
        return this.l;
    }
}

