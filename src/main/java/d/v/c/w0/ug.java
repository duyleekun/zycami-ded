/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ug
extends ViewDataBinding {
    public final TextView a;
    public String b;
    public boolean c;

    public ug(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static ug s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ug.t(view, dataBindingComponent);
    }

    public static ug t(View view, Object object) {
        return (ug)ViewDataBinding.bind(object, view, 2131558766);
    }

    public static ug w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ug.z(layoutInflater, dataBindingComponent);
    }

    public static ug x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ug.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ug y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ug)ViewDataBinding.inflateInternal(layoutInflater, 2131558766, viewGroup, bl2, object);
    }

    public static ug z(LayoutInflater layoutInflater, Object object) {
        return (ug)ViewDataBinding.inflateInternal(layoutInflater, 2131558766, null, false, object);
    }

    public abstract void A(boolean var1);

    public abstract void B(String var1);

    public boolean u() {
        return this.c;
    }

    public String v() {
        return this.b;
    }
}

