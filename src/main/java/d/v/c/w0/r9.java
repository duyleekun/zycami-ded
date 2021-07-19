/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.home.MeasureTextView;
import d.v.c.i1.s2.r$c;
import d.v.g.g.c1;

public abstract class r9
extends ViewDataBinding {
    public final ImageView a;
    public final MeasureTextView b;
    public final MeasureTextView c;
    public c1 d;
    public r$c e;

    public r9(Object object, View view, int n10, ImageView imageView, MeasureTextView measureTextView, MeasureTextView measureTextView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = measureTextView;
        this.c = measureTextView2;
    }

    public static r9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r9.t(view, dataBindingComponent);
    }

    public static r9 t(View view, Object object) {
        return (r9)ViewDataBinding.bind(object, view, 2131558614);
    }

    public static r9 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r9.z(layoutInflater, dataBindingComponent);
    }

    public static r9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r9.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r9)ViewDataBinding.inflateInternal(layoutInflater, 2131558614, viewGroup, bl2, object);
    }

    public static r9 z(LayoutInflater layoutInflater, Object object) {
        return (r9)ViewDataBinding.inflateInternal(layoutInflater, 2131558614, null, false, object);
    }

    public abstract void A(r$c var1);

    public abstract void B(c1 var1);

    public r$c u() {
        return this.e;
    }

    public c1 v() {
        return this.d;
    }
}

