/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.m1.d.o$b;

public abstract class h5
extends ViewDataBinding {
    public final View a;
    public final EditText b;
    public final FrameLayout c;
    public final View d;
    public final Guideline e;
    public final TextView f;
    public final Button g;
    public final Button h;
    public final TextView i;
    public final View j;
    public final View k;
    public o$b l;

    public h5(Object object, View view, int n10, View view2, EditText editText, FrameLayout frameLayout, View view3, Guideline guideline, TextView textView, Button button, Button button2, TextView textView2, View view4, View view5) {
        super(object, view, n10);
        this.a = view2;
        this.b = editText;
        this.c = frameLayout;
        this.d = view3;
        this.e = guideline;
        this.f = textView;
        this.g = button;
        this.h = button2;
        this.i = textView2;
        this.j = view4;
        this.k = view5;
    }

    public static h5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h5.t(view, dataBindingComponent);
    }

    public static h5 t(View view, Object object) {
        return (h5)ViewDataBinding.bind(object, view, 2131558552);
    }

    public static h5 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h5.y(layoutInflater, dataBindingComponent);
    }

    public static h5 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h5.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h5)ViewDataBinding.inflateInternal(layoutInflater, 2131558552, viewGroup, bl2, object);
    }

    public static h5 y(LayoutInflater layoutInflater, Object object) {
        return (h5)ViewDataBinding.inflateInternal(layoutInflater, 2131558552, null, false, object);
    }

    public o$b u() {
        return this.l;
    }

    public abstract void z(o$b var1);
}

