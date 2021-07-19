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
import com.zhiyun.cama.me.message.MessageTextFragment$a;

public abstract class of
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public MessageTextFragment$a f;

    public of(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static of s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return of.t(view, dataBindingComponent);
    }

    public static of t(View view, Object object) {
        return (of)ViewDataBinding.bind(object, view, 2131558710);
    }

    public static of v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return of.y(layoutInflater, dataBindingComponent);
    }

    public static of w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return of.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static of x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (of)ViewDataBinding.inflateInternal(layoutInflater, 2131558710, viewGroup, bl2, object);
    }

    public static of y(LayoutInflater layoutInflater, Object object) {
        return (of)ViewDataBinding.inflateInternal(layoutInflater, 2131558710, null, false, object);
    }

    public MessageTextFragment$a u() {
        return this.f;
    }

    public abstract void z(MessageTextFragment$a var1);
}

