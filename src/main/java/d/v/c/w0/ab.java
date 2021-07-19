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
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.b2.v.b;
import d.v.c.b2.w.a;

public abstract class ab
extends ViewDataBinding {
    public final ImageView a;
    public final RoundImageView b;
    public final TextView c;
    public final View d;
    public final RingProgressBar e;
    public a f;
    public Integer g;
    public ObservableList h;
    public b i;

    public ab(Object object, View view, int n10, ImageView imageView, RoundImageView roundImageView, TextView textView, View view2, RingProgressBar ringProgressBar) {
        super(object, view, n10);
        this.a = imageView;
        this.b = roundImageView;
        this.c = textView;
        this.d = view2;
        this.e = ringProgressBar;
    }

    public static ab A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ab)ViewDataBinding.inflateInternal(layoutInflater, 2131558631, viewGroup, bl2, object);
    }

    public static ab B(LayoutInflater layoutInflater, Object object) {
        return (ab)ViewDataBinding.inflateInternal(layoutInflater, 2131558631, null, false, object);
    }

    public static ab s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ab.t(view, dataBindingComponent);
    }

    public static ab t(View view, Object object) {
        return (ab)ViewDataBinding.bind(object, view, 2131558631);
    }

    public static ab y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ab.B(layoutInflater, dataBindingComponent);
    }

    public static ab z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ab.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(ObservableList var1);

    public abstract void D(Integer var1);

    public abstract void E(a var1);

    public abstract void F(b var1);

    public ObservableList u() {
        return this.h;
    }

    public Integer v() {
        return this.g;
    }

    public a w() {
        return this.f;
    }

    public b x() {
        return this.i;
    }
}

