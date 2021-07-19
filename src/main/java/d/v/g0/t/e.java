/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;
import d.v.g0.k$c;

public abstract class e
extends ViewDataBinding {
    public final View a;
    public final EditText b;
    public final ConstraintLayout c;
    public final View d;
    public final Guideline e;
    public final Button f;
    public final Button g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public k$c l;

    public e(Object object, View view, int n10, View view2, EditText editText, ConstraintLayout constraintLayout, View view3, Guideline guideline, Button button, Button button2, TextView textView, TextView textView2, TextView textView3, View view4) {
        super(object, view, n10);
        this.a = view2;
        this.b = editText;
        this.c = constraintLayout;
        this.d = view3;
        this.e = guideline;
        this.f = button;
        this.g = button2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = view4;
    }

    public static e s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.e.t(view, dataBindingComponent);
    }

    public static e t(View view, Object object) {
        int n10 = R$layout.zyui_frag_confirm;
        return (e)ViewDataBinding.bind(object, view, n10);
    }

    public static e v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.e.y(layoutInflater, dataBindingComponent);
    }

    public static e w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.g0.t.e.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static e x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.zyui_frag_confirm;
        return (e)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static e y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.zyui_frag_confirm;
        return (e)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public k$c u() {
        return this.l;
    }

    public abstract void z(k$c var1);
}

