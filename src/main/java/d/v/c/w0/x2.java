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
import com.zhiyun.cama.publish.CreationFragment$a;

public abstract class x2
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public CreationFragment$a i;

    public x2(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = imageView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
    }

    public static x2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x2.t(view, dataBindingComponent);
    }

    public static x2 t(View view, Object object) {
        return (x2)ViewDataBinding.bind(object, view, 2131558493);
    }

    public static x2 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x2.y(layoutInflater, dataBindingComponent);
    }

    public static x2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x2.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x2)ViewDataBinding.inflateInternal(layoutInflater, 2131558493, viewGroup, bl2, object);
    }

    public static x2 y(LayoutInflater layoutInflater, Object object) {
        return (x2)ViewDataBinding.inflateInternal(layoutInflater, 2131558493, null, false, object);
    }

    public CreationFragment$a u() {
        return this.i;
    }

    public abstract void z(CreationFragment$a var1);
}

