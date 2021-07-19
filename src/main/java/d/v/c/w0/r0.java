/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.widget.StringScrollView;
import d.v.c.s0.a7.y0$a;

public abstract class r0
extends ViewDataBinding {
    public final CheckBox a;
    public final View b;
    public final View c;
    public final View d;
    public final LinearLayout e;
    public final StringScrollView f;
    public final StringScrollView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public y0.a l;

    public r0(Object object, View view, int n10, CheckBox checkBox, View view2, View view3, View view4, LinearLayout linearLayout, StringScrollView stringScrollView, StringScrollView stringScrollView2, TextView textView, TextView textView2, TextView textView3, View view5) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = view2;
        this.c = view3;
        this.d = view4;
        this.e = linearLayout;
        this.f = stringScrollView;
        this.g = stringScrollView2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = view5;
    }

    public static r0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r0.t(view, dataBindingComponent);
    }

    public static r0 t(View view, Object object) {
        return (r0)ViewDataBinding.bind(object, view, 2131558462);
    }

    public static r0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r0.y(layoutInflater, dataBindingComponent);
    }

    public static r0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r0)ViewDataBinding.inflateInternal(layoutInflater, 2131558462, viewGroup, bl2, object);
    }

    public static r0 y(LayoutInflater layoutInflater, Object object) {
        return (r0)ViewDataBinding.inflateInternal(layoutInflater, 2131558462, null, false, object);
    }

    public y0.a u() {
        return this.l;
    }

    public abstract void z(y0.a var1);
}

