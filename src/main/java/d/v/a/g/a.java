/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;

public abstract class a
extends ViewDataBinding {
    public final TextView a;
    public final FrameLayout b;
    public final LinearLayout c;
    public final ProgressBar d;
    public final TextView e;
    public final TextView f;
    public ObservableField g;
    public ObservableField h;

    public a(Object object, View view, int n10, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, ProgressBar progressBar, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = textView;
        this.b = frameLayout;
        this.c = linearLayout;
        this.d = progressBar;
        this.e = textView2;
        this.f = textView3;
    }

    public static a s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.a.t(view, dataBindingComponent);
    }

    public static a t(View view, Object object) {
        int n10 = R$layout.base_status_view;
        return (a)ViewDataBinding.bind(object, view, n10);
    }

    public static a w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.a.z(layoutInflater, dataBindingComponent);
    }

    public static a x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.a.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static a y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.base_status_view;
        return (a)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static a z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.base_status_view;
        return (a)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(ObservableField var1);

    public abstract void B(ObservableField var1);

    public ObservableField u() {
        return this.h;
    }

    public ObservableField v() {
        return this.g;
    }
}

