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
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.i.a.m0;
import d.v.a.i.a.v0.m$b;

public abstract class c
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final CheckBox c;
    public final ImageView d;
    public final ImageView e;
    public final MeNameView f;
    public final MeGetCodeView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public m$b k;
    public m0 l;

    public c(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, ImageView imageView, ImageView imageView2, MeNameView meNameView, MeGetCodeView meGetCodeView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = checkBox3;
        this.d = imageView;
        this.e = imageView2;
        this.f = meNameView;
        this.g = meGetCodeView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static c s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.c.t(view, dataBindingComponent);
    }

    public static c t(View view, Object object) {
        int n10 = R$layout.me_account_get_code_frag;
        return (c)ViewDataBinding.bind(object, view, n10);
    }

    public static c w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.c.z(layoutInflater, dataBindingComponent);
    }

    public static c x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.c.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static c y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_account_get_code_frag;
        return (c)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static c z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_account_get_code_frag;
        return (c)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(m$b var1);

    public abstract void B(m0 var1);

    public m$b u() {
        return this.k;
    }

    public m0 v() {
        return this.l;
    }
}

