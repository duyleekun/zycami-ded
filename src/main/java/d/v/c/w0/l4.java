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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.u0.m;
import d.v.c.u0.n$a;
import d.v.c.w0.wi;

public abstract class l4
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final wi c;
    public final ZYTextView d;
    public final View e;
    public final ThumbnailView f;
    public m g;
    public n.a h;

    public l4(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageView imageView, wi wi2, ZYTextView zYTextView, View view2, ThumbnailView thumbnailView) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageView;
        this.c = wi2;
        this.d = zYTextView;
        this.e = view2;
        this.f = thumbnailView;
    }

    public static l4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l4.t(view, dataBindingComponent);
    }

    public static l4 t(View view, Object object) {
        return (l4)ViewDataBinding.bind(object, view, 2131558530);
    }

    public static l4 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l4.z(layoutInflater, dataBindingComponent);
    }

    public static l4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l4.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l4 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l4)ViewDataBinding.inflateInternal(layoutInflater, 2131558530, viewGroup, bl2, object);
    }

    public static l4 z(LayoutInflater layoutInflater, Object object) {
        return (l4)ViewDataBinding.inflateInternal(layoutInflater, 2131558530, null, false, object);
    }

    public abstract void A(n.a var1);

    public abstract void B(m var1);

    public n.a u() {
        return this.h;
    }

    public m v() {
        return this.g;
    }
}

