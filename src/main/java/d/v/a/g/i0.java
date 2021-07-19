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
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.j.c.y;
import d.v.a.j.c.z.j$b;

public abstract class i0
extends ViewDataBinding {
    public final ImageView a;
    public final MeNameView b;
    public final MeGetCodeView c;
    public final TextView d;
    public final TextView e;
    public j$b f;
    public y g;

    public i0(Object object, View view, int n10, ImageView imageView, MeNameView meNameView, MeGetCodeView meGetCodeView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = meNameView;
        this.c = meGetCodeView;
        this.d = textView;
        this.e = textView2;
    }

    public static i0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i0.t(view, dataBindingComponent);
    }

    public static i0 t(View view, Object object) {
        int n10 = R$layout.set_private_get_code_frag;
        return (i0)ViewDataBinding.bind(object, view, n10);
    }

    public static i0 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i0.z(layoutInflater, dataBindingComponent);
    }

    public static i0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i0.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static i0 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_get_code_frag;
        return (i0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static i0 z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_get_code_frag;
        return (i0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(j$b var1);

    public abstract void B(y var1);

    public j$b u() {
        return this.f;
    }

    public y v() {
        return this.g;
    }
}

