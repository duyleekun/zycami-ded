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
import com.zhiyun.cama.device.active.ActivationAccountFragment$a;
import com.zhiyun.device.active.ActivationViewModel;

public abstract class j5
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public ActivationAccountFragment$a e;
    public ActivationViewModel f;

    public j5(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static j5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j5.t(view, dataBindingComponent);
    }

    public static j5 t(View view, Object object) {
        return (j5)ViewDataBinding.bind(object, view, 2131558553);
    }

    public static j5 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j5.z(layoutInflater, dataBindingComponent);
    }

    public static j5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j5.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j5)ViewDataBinding.inflateInternal(layoutInflater, 2131558553, viewGroup, bl2, object);
    }

    public static j5 z(LayoutInflater layoutInflater, Object object) {
        return (j5)ViewDataBinding.inflateInternal(layoutInflater, 2131558553, null, false, object);
    }

    public abstract void A(ActivationAccountFragment$a var1);

    public abstract void B(ActivationViewModel var1);

    public ActivationAccountFragment$a u() {
        return this.e;
    }

    public ActivationViewModel v() {
        return this.f;
    }
}

