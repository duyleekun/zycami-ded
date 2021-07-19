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
import com.zhiyun.device.active.ActivationViewModel;

public abstract class p5
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public ActivationViewModel i;

    public p5(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
    }

    public static p5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p5.t(view, dataBindingComponent);
    }

    public static p5 t(View view, Object object) {
        return (p5)ViewDataBinding.bind(object, view, 2131558556);
    }

    public static p5 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p5.y(layoutInflater, dataBindingComponent);
    }

    public static p5 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p5.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p5 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p5)ViewDataBinding.inflateInternal(layoutInflater, 2131558556, viewGroup, bl2, object);
    }

    public static p5 y(LayoutInflater layoutInflater, Object object) {
        return (p5)ViewDataBinding.inflateInternal(layoutInflater, 2131558556, null, false, object);
    }

    public ActivationViewModel u() {
        return this.i;
    }

    public abstract void z(ActivationViewModel var1);
}

