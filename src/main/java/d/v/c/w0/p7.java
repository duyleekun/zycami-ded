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
import com.zhiyun.cama.rotate.EditorRotateFragment$a;
import com.zhiyun.cama.widget.HorizontalScrollView;
import d.v.c.p1.e;
import d.v.c.w0.b5;
import d.v.c.w0.j4;

public abstract class p7
extends ViewDataBinding {
    public final j4 a;
    public final b5 b;
    public final HorizontalScrollView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final TextView h;
    public EditorRotateFragment$a i;
    public e j;

    public p7(Object object, View view, int n10, j4 j42, b5 b52, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView) {
        super(object, view, n10);
        this.a = j42;
        this.b = b52;
        this.c = horizontalScrollView;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = textView;
    }

    public static p7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p7.t(view, dataBindingComponent);
    }

    public static p7 t(View view, Object object) {
        return (p7)ViewDataBinding.bind(object, view, 2131558582);
    }

    public static p7 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p7.z(layoutInflater, dataBindingComponent);
    }

    public static p7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p7.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p7)ViewDataBinding.inflateInternal(layoutInflater, 2131558582, viewGroup, bl2, object);
    }

    public static p7 z(LayoutInflater layoutInflater, Object object) {
        return (p7)ViewDataBinding.inflateInternal(layoutInflater, 2131558582, null, false, object);
    }

    public abstract void A(EditorRotateFragment$a var1);

    public abstract void B(e var1);

    public EditorRotateFragment$a u() {
        return this.i;
    }

    public e v() {
        return this.j;
    }
}

