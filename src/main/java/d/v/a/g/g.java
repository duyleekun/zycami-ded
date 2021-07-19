/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.LoginQuickFragment$b;
import com.zhiyun.account.me.account.widget.InputCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.i.a.m0;

public abstract class g
extends ViewDataBinding {
    public final Button a;
    public final CheckBox b;
    public final TextView c;
    public final InputCodeView d;
    public final ImageView e;
    public final ImageView f;
    public final MeNameView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public LoginQuickFragment$b m;
    public m0 n;

    public g(Object object, View view, int n10, Button button, CheckBox checkBox, TextView textView, InputCodeView inputCodeView, ImageView imageView, ImageView imageView2, MeNameView meNameView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = button;
        this.b = checkBox;
        this.c = textView;
        this.d = inputCodeView;
        this.e = imageView;
        this.f = imageView2;
        this.g = meNameView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
    }

    public static g s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.g.t(view, dataBindingComponent);
    }

    public static g t(View view, Object object) {
        int n10 = R$layout.me_account_login_quick_frag;
        return (g)ViewDataBinding.bind(object, view, n10);
    }

    public static g w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.g.z(layoutInflater, dataBindingComponent);
    }

    public static g x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.g.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static g y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_account_login_quick_frag;
        return (g)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static g z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_account_login_quick_frag;
        return (g)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(LoginQuickFragment$b var1);

    public abstract void B(m0 var1);

    public LoginQuickFragment$b u() {
        return this.m;
    }

    public m0 v() {
        return this.n;
    }
}

