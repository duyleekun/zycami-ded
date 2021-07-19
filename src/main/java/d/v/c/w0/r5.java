/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.device.active.ActivationSuccessFragment$b;
import d.v.c.y0.a.p;

public abstract class r5
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public ActivationSuccessFragment$b d;
    public p e;

    public r5(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static r5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r5.t(view, dataBindingComponent);
    }

    public static r5 t(View view, Object object) {
        return (r5)ViewDataBinding.bind(object, view, 2131558557);
    }

    public static r5 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r5.z(layoutInflater, dataBindingComponent);
    }

    public static r5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r5.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r5)ViewDataBinding.inflateInternal(layoutInflater, 2131558557, viewGroup, bl2, object);
    }

    public static r5 z(LayoutInflater layoutInflater, Object object) {
        return (r5)ViewDataBinding.inflateInternal(layoutInflater, 2131558557, null, false, object);
    }

    public abstract void A(ActivationSuccessFragment$b var1);

    public abstract void B(p var1);

    public ActivationSuccessFragment$b u() {
        return this.d;
    }

    public p v() {
        return this.e;
    }
}

