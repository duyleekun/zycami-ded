/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.q0.f.a;

public abstract class b5
extends ViewDataBinding {
    public final CheckedTextView a;
    public final TextView b;
    public a c;

    public b5(Object object, View view, int n10, CheckedTextView checkedTextView, TextView textView) {
        super(object, view, n10);
        this.a = checkedTextView;
        this.b = textView;
    }

    public static b5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b5.t(view, dataBindingComponent);
    }

    public static b5 t(View view, Object object) {
        return (b5)ViewDataBinding.bind(object, view, 2131558538);
    }

    public static b5 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b5.y(layoutInflater, dataBindingComponent);
    }

    public static b5 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b5.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b5)ViewDataBinding.inflateInternal(layoutInflater, 2131558538, viewGroup, bl2, object);
    }

    public static b5 y(LayoutInflater layoutInflater, Object object) {
        return (b5)ViewDataBinding.inflateInternal(layoutInflater, 2131558538, null, false, object);
    }

    public a u() {
        return this.c;
    }

    public abstract void z(a var1);
}

