/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.l1.e0.b$b;

public abstract class v3
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final RelativeLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public b$b h;

    public v3(Object object, View view, int n10, FrameLayout frameLayout, ImageView imageView, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageView;
        this.c = relativeLayout;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    public static v3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v3.t(view, dataBindingComponent);
    }

    public static v3 t(View view, Object object) {
        return (v3)ViewDataBinding.bind(object, view, 2131558522);
    }

    public static v3 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v3.y(layoutInflater, dataBindingComponent);
    }

    public static v3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v3.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v3)ViewDataBinding.inflateInternal(layoutInflater, 2131558522, viewGroup, bl2, object);
    }

    public static v3 y(LayoutInflater layoutInflater, Object object) {
        return (v3)ViewDataBinding.inflateInternal(layoutInflater, 2131558522, null, false, object);
    }

    public b$b u() {
        return this.h;
    }

    public abstract void z(b$b var1);
}

