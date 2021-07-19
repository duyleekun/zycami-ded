/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.z0.k$c;
import d.v.c.z0.l;

public abstract class yg
extends ViewDataBinding {
    public final CheckBox a;
    public final ConstraintLayout b;
    public final ScrollView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final View j;
    public k$c k;
    public l l;

    public yg(Object object, View view, int n10, CheckBox checkBox, ConstraintLayout constraintLayout, ScrollView scrollView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = constraintLayout;
        this.c = scrollView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = view2;
        this.j = view3;
    }

    public static yg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yg.t(view, dataBindingComponent);
    }

    public static yg t(View view, Object object) {
        return (yg)ViewDataBinding.bind(object, view, 2131558768);
    }

    public static yg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yg.z(layoutInflater, dataBindingComponent);
    }

    public static yg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return yg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static yg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (yg)ViewDataBinding.inflateInternal(layoutInflater, 2131558768, viewGroup, bl2, object);
    }

    public static yg z(LayoutInflater layoutInflater, Object object) {
        return (yg)ViewDataBinding.inflateInternal(layoutInflater, 2131558768, null, false, object);
    }

    public abstract void A(k$c var1);

    public abstract void B(l var1);

    public k$c u() {
        return this.k;
    }

    public l v() {
        return this.l;
    }
}

