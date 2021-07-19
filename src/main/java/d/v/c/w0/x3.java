/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.l1.e0.d$b;

public abstract class x3
extends ViewDataBinding {
    public final RadioButton a;
    public final RadioButton b;
    public final RadioButton c;
    public final View d;
    public final View e;
    public final View f;
    public final TextView g;
    public final RadioGroup h;
    public d$b i;

    public x3(Object object, View view, int n10, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, View view2, View view3, View view4, TextView textView, RadioGroup radioGroup) {
        super(object, view, n10);
        this.a = radioButton;
        this.b = radioButton2;
        this.c = radioButton3;
        this.d = view2;
        this.e = view3;
        this.f = view4;
        this.g = textView;
        this.h = radioGroup;
    }

    public static x3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x3.t(view, dataBindingComponent);
    }

    public static x3 t(View view, Object object) {
        return (x3)ViewDataBinding.bind(object, view, 2131558523);
    }

    public static x3 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x3.y(layoutInflater, dataBindingComponent);
    }

    public static x3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x3.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x3)ViewDataBinding.inflateInternal(layoutInflater, 2131558523, viewGroup, bl2, object);
    }

    public static x3 y(LayoutInflater layoutInflater, Object object) {
        return (x3)ViewDataBinding.inflateInternal(layoutInflater, 2131558523, null, false, object);
    }

    public d$b u() {
        return this.i;
    }

    public abstract void z(d$b var1);
}

