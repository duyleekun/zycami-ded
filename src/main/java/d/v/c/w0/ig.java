/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.n1.i2$b;
import d.v.c.n1.j2;

public abstract class ig
extends ViewDataBinding {
    public final EditText a;
    public final ImageView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final HorizontalScrollView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public i2$b j;
    public j2 k;

    public ig(Object object, View view, int n10, EditText editText, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, HorizontalScrollView horizontalScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = editText;
        this.b = imageView;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = horizontalScrollView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    public static ig s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ig.t(view, dataBindingComponent);
    }

    public static ig t(View view, Object object) {
        return (ig)ViewDataBinding.bind(object, view, 2131558748);
    }

    public static ig w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ig.z(layoutInflater, dataBindingComponent);
    }

    public static ig x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ig.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ig y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ig)ViewDataBinding.inflateInternal(layoutInflater, 2131558748, viewGroup, bl2, object);
    }

    public static ig z(LayoutInflater layoutInflater, Object object) {
        return (ig)ViewDataBinding.inflateInternal(layoutInflater, 2131558748, null, false, object);
    }

    public abstract void A(i2$b var1);

    public abstract void B(j2 var1);

    public i2$b u() {
        return this.j;
    }

    public j2 v() {
        return this.k;
    }
}

