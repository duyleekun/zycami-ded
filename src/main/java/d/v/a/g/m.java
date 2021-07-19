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
import com.zhiyun.account.me.account.SetPassFragment$a;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.i.a.m0;

public abstract class m
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final ImageView c;
    public final ImageView d;
    public final MePassView e;
    public final MePassView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public SetPassFragment$a j;
    public m0 k;

    public m(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, ImageView imageView, ImageView imageView2, MePassView mePassView, MePassView mePassView2, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = imageView;
        this.d = imageView2;
        this.e = mePassView;
        this.f = mePassView2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public static m s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m.t(view, dataBindingComponent);
    }

    public static m t(View view, Object object) {
        int n10 = R$layout.me_acoount_set_pass_frag;
        return (m)ViewDataBinding.bind(object, view, n10);
    }

    public static m w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m.z(layoutInflater, dataBindingComponent);
    }

    public static m x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static m y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_acoount_set_pass_frag;
        return (m)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static m z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_acoount_set_pass_frag;
        return (m)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(SetPassFragment$a var1);

    public abstract void B(m0 var1);

    public SetPassFragment$a u() {
        return this.j;
    }

    public m0 v() {
        return this.k;
    }
}

