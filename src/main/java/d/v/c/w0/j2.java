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
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.s0.a7.l1$b;

public abstract class j2
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public BleViewModel h;
    public l1$b i;

    public j2(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, View view2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = textView;
        this.f = textView2;
        this.g = view2;
    }

    public static j2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j2.t(view, dataBindingComponent);
    }

    public static j2 t(View view, Object object) {
        return (j2)ViewDataBinding.bind(object, view, 2131558484);
    }

    public static j2 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j2.z(layoutInflater, dataBindingComponent);
    }

    public static j2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j2.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j2)ViewDataBinding.inflateInternal(layoutInflater, 2131558484, viewGroup, bl2, object);
    }

    public static j2 z(LayoutInflater layoutInflater, Object object) {
        return (j2)ViewDataBinding.inflateInternal(layoutInflater, 2131558484, null, false, object);
    }

    public abstract void A(BleViewModel var1);

    public abstract void B(l1$b var1);

    public BleViewModel u() {
        return this.h;
    }

    public l1$b v() {
        return this.i;
    }
}

