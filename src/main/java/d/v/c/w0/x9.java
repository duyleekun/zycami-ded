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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

public abstract class x9
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public ObservableBoolean c;
    public ObservableBoolean d;
    public ObservableField e;

    public x9(Object object, View view, int n10, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
    }

    public static x9 A(LayoutInflater layoutInflater, Object object) {
        return (x9)ViewDataBinding.inflateInternal(layoutInflater, 2131558617, null, false, object);
    }

    public static x9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x9.t(view, dataBindingComponent);
    }

    public static x9 t(View view, Object object) {
        return (x9)ViewDataBinding.bind(object, view, 2131558617);
    }

    public static x9 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x9.A(layoutInflater, dataBindingComponent);
    }

    public static x9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x9.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x9)ViewDataBinding.inflateInternal(layoutInflater, 2131558617, viewGroup, bl2, object);
    }

    public abstract void B(ObservableBoolean var1);

    public abstract void C(ObservableBoolean var1);

    public abstract void D(ObservableField var1);

    public ObservableBoolean u() {
        return this.d;
    }

    public ObservableBoolean v() {
        return this.c;
    }

    public ObservableField w() {
        return this.e;
    }
}

