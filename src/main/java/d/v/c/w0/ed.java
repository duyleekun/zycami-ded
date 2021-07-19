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
import d.v.c.b2.v.b;
import d.v.c.b2.w.a;

public abstract class ed
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final View c;
    public final RingProgressBar d;
    public a e;
    public ObservableList f;
    public Integer g;
    public b h;

    public ed(Object object, View view, int n10, ImageView imageView, TextView textView, View view2, RingProgressBar ringProgressBar) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = view2;
        this.d = ringProgressBar;
    }

    public static ed A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ed)ViewDataBinding.inflateInternal(layoutInflater, 2131558661, viewGroup, bl2, object);
    }

    public static ed B(LayoutInflater layoutInflater, Object object) {
        return (ed)ViewDataBinding.inflateInternal(layoutInflater, 2131558661, null, false, object);
    }

    public static ed s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ed.t(view, dataBindingComponent);
    }

    public static ed t(View view, Object object) {
        return (ed)ViewDataBinding.bind(object, view, 2131558661);
    }

    public static ed y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ed.B(layoutInflater, dataBindingComponent);
    }

    public static ed z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ed.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(ObservableList var1);

    public abstract void D(Integer var1);

    public abstract void E(a var1);

    public abstract void F(b var1);

    public ObservableList u() {
        return this.f;
    }

    public Integer v() {
        return this.g;
    }

    public a w() {
        return this.e;
    }

    public b x() {
        return this.h;
    }
}

