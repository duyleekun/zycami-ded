/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.component.widget.JSWebView;
import d.v.c.i1.t2.f0$c;
import d.v.c.i1.t2.o0;

public abstract class z
extends ViewDataBinding {
    public final ImageView a;
    public final FrameLayout b;
    public final StatusView c;
    public final JSWebView d;
    public f0$c e;
    public o0 f;

    public z(Object object, View view, int n10, ImageView imageView, FrameLayout frameLayout, StatusView statusView, JSWebView jSWebView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = frameLayout;
        this.c = statusView;
        this.d = jSWebView;
    }

    public static z s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z.t(view, dataBindingComponent);
    }

    public static z t(View view, Object object) {
        return (z)ViewDataBinding.bind(object, view, 2131558450);
    }

    public static z w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z.z(layoutInflater, dataBindingComponent);
    }

    public static z x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z)ViewDataBinding.inflateInternal(layoutInflater, 2131558450, viewGroup, bl2, object);
    }

    public static z z(LayoutInflater layoutInflater, Object object) {
        return (z)ViewDataBinding.inflateInternal(layoutInflater, 2131558450, null, false, object);
    }

    public abstract void A(f0$c var1);

    public abstract void B(o0 var1);

    public f0$c u() {
        return this.e;
    }

    public o0 v() {
        return this.f;
    }
}

