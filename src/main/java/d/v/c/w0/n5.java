/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.device.active.ActivationPrepareFragment$c;
import d.v.c.y0.a.p;

public abstract class n5
extends ViewDataBinding {
    public final CheckBox a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public ActivationPrepareFragment$c h;
    public p i;

    public n5(Object object, View view, int n10, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    public static n5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n5.t(view, dataBindingComponent);
    }

    public static n5 t(View view, Object object) {
        return (n5)ViewDataBinding.bind(object, view, 2131558555);
    }

    public static n5 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n5.z(layoutInflater, dataBindingComponent);
    }

    public static n5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n5.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n5)ViewDataBinding.inflateInternal(layoutInflater, 2131558555, viewGroup, bl2, object);
    }

    public static n5 z(LayoutInflater layoutInflater, Object object) {
        return (n5)ViewDataBinding.inflateInternal(layoutInflater, 2131558555, null, false, object);
    }

    public abstract void A(ActivationPrepareFragment$c var1);

    public abstract void B(p var1);

    public ActivationPrepareFragment$c u() {
        return this.h;
    }

    public p v() {
        return this.i;
    }
}

