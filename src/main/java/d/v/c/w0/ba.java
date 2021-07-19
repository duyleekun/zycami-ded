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

public abstract class ba
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
    public Boolean j;

    public ba(Object object, View view, int n10, ImageView imageView, RoundImageView roundImageView, TextView textView, View view2, RingProgressBar ringProgressBar) {
        super(object, view, n10);
        this.a = imageView;
        this.b = roundImageView;
        this.c = textView;
        this.d = view2;
        this.e = ringProgressBar;
    }

    public static ba A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ba.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ba B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ba)ViewDataBinding.inflateInternal(layoutInflater, 2131558619, viewGroup, bl2, object);
    }

    public static ba C(LayoutInflater layoutInflater, Object object) {
        return (ba)ViewDataBinding.inflateInternal(layoutInflater, 2131558619, null, false, object);
    }

    public static ba s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ba.t(view, dataBindingComponent);
    }

    public static ba t(View view, Object object) {
        return (ba)ViewDataBinding.bind(object, view, 2131558619);
    }

    public static ba z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ba.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(a var1);

    public abstract void E(Boolean var1);

    public abstract void F(ObservableList var1);

    public abstract void G(Integer var1);

    public abstract void H(b var1);

    public a u() {
        return this.f;
    }

    public Boolean v() {
        return this.j;
    }

    public ObservableList w() {
        return this.h;
    }

    public Integer x() {
        return this.g;
    }

    public b y() {
        return this.i;
    }
}

