/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CECompositingDialog$b;
import d.v.c.t0.v;

public abstract class l3
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ProgressBar d;
    public final TextView e;
    public final TextView f;
    public v g;
    public CECompositingDialog.b h;

    public l3(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, ProgressBar progressBar, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = progressBar;
        this.e = textView3;
        this.f = textView4;
    }

    public static l3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l3.t(view, dataBindingComponent);
    }

    public static l3 t(View view, Object object) {
        return (l3)ViewDataBinding.bind(object, view, 2131558516);
    }

    public static l3 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l3.z(layoutInflater, dataBindingComponent);
    }

    public static l3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l3.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l3 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l3)ViewDataBinding.inflateInternal(layoutInflater, 2131558516, viewGroup, bl2, object);
    }

    public static l3 z(LayoutInflater layoutInflater, Object object) {
        return (l3)ViewDataBinding.inflateInternal(layoutInflater, 2131558516, null, false, object);
    }

    public abstract void A(CECompositingDialog.b var1);

    public abstract void B(v var1);

    public CECompositingDialog.b u() {
        return this.h;
    }

    public v v() {
        return this.g;
    }
}

