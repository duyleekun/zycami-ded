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
import com.zhiyun.cama.set.SetAboutFragment$a;
import d.v.c.q1.g0;

public abstract class kg
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public SetAboutFragment$a e;
    public g0 f;

    public kg(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static kg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kg.t(view, dataBindingComponent);
    }

    public static kg t(View view, Object object) {
        return (kg)ViewDataBinding.bind(object, view, 2131558753);
    }

    public static kg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kg.z(layoutInflater, dataBindingComponent);
    }

    public static kg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static kg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kg)ViewDataBinding.inflateInternal(layoutInflater, 2131558753, viewGroup, bl2, object);
    }

    public static kg z(LayoutInflater layoutInflater, Object object) {
        return (kg)ViewDataBinding.inflateInternal(layoutInflater, 2131558753, null, false, object);
    }

    public abstract void A(SetAboutFragment$a var1);

    public abstract void B(g0 var1);

    public SetAboutFragment$a u() {
        return this.e;
    }

    public g0 v() {
        return this.f;
    }
}

