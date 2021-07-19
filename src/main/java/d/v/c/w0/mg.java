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
import com.zhiyun.cama.set.SetCacheFragment$a;
import d.v.c.q1.g0;

public abstract class mg
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public SetCacheFragment$a c;
    public g0 d;

    public mg(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static mg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mg.t(view, dataBindingComponent);
    }

    public static mg t(View view, Object object) {
        return (mg)ViewDataBinding.bind(object, view, 2131558754);
    }

    public static mg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mg.z(layoutInflater, dataBindingComponent);
    }

    public static mg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mg)ViewDataBinding.inflateInternal(layoutInflater, 2131558754, viewGroup, bl2, object);
    }

    public static mg z(LayoutInflater layoutInflater, Object object) {
        return (mg)ViewDataBinding.inflateInternal(layoutInflater, 2131558754, null, false, object);
    }

    public abstract void A(SetCacheFragment$a var1);

    public abstract void B(g0 var1);

    public SetCacheFragment$a u() {
        return this.c;
    }

    public g0 v() {
        return this.d;
    }
}

