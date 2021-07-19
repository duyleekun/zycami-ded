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
import com.zhiyun.cama.me.message.MessageFragment$a;
import d.v.c.j1.b.o0;

public abstract class ef
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public o0 f;
    public MessageFragment$a g;

    public ef(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static ef s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ef.t(view, dataBindingComponent);
    }

    public static ef t(View view, Object object) {
        return (ef)ViewDataBinding.bind(object, view, 2131558705);
    }

    public static ef w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ef.z(layoutInflater, dataBindingComponent);
    }

    public static ef x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ef.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ef y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ef)ViewDataBinding.inflateInternal(layoutInflater, 2131558705, viewGroup, bl2, object);
    }

    public static ef z(LayoutInflater layoutInflater, Object object) {
        return (ef)ViewDataBinding.inflateInternal(layoutInflater, 2131558705, null, false, object);
    }

    public abstract void A(MessageFragment$a var1);

    public abstract void B(o0 var1);

    public MessageFragment$a u() {
        return this.g;
    }

    public o0 v() {
        return this.f;
    }
}

