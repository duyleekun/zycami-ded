/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;

public abstract class a
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public boolean g;

    public a(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = linearLayout;
        this.e = textView;
        this.f = textView2;
    }

    public static a s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.a.t(view, dataBindingComponent);
    }

    public static a t(View view, Object object) {
        int n10 = R$layout.zyui_appbars;
        return (a)ViewDataBinding.bind(object, view, n10);
    }

    public static a v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.a.y(layoutInflater, dataBindingComponent);
    }

    public static a w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.a.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static a x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.zyui_appbars;
        return (a)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static a y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.zyui_appbars;
        return (a)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public boolean u() {
        return this.g;
    }

    public abstract void z(boolean var1);
}

