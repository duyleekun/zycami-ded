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
import com.zhiyun.cama.device.active.ActivationFailFragment$b;
import com.zhiyun.device.active.ActivationViewModel;

public abstract class l5
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public ActivationFailFragment$b e;
    public ActivationViewModel f;

    public l5(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static l5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l5.t(view, dataBindingComponent);
    }

    public static l5 t(View view, Object object) {
        return (l5)ViewDataBinding.bind(object, view, 2131558554);
    }

    public static l5 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l5.z(layoutInflater, dataBindingComponent);
    }

    public static l5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l5.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l5)ViewDataBinding.inflateInternal(layoutInflater, 2131558554, viewGroup, bl2, object);
    }

    public static l5 z(LayoutInflater layoutInflater, Object object) {
        return (l5)ViewDataBinding.inflateInternal(layoutInflater, 2131558554, null, false, object);
    }

    public abstract void A(ActivationFailFragment$b var1);

    public abstract void B(ActivationViewModel var1);

    public ActivationFailFragment$b u() {
        return this.e;
    }

    public ActivationViewModel v() {
        return this.f;
    }
}

