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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.help.FeedbackFragment$a;
import d.v.c.j1.a.o0;

public abstract class we
extends ViewDataBinding {
    public final ImageView a;
    public FeedbackFragment$a b;
    public o0 c;

    public we(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static we s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return we.t(view, dataBindingComponent);
    }

    public static we t(View view, Object object) {
        return (we)ViewDataBinding.bind(object, view, 2131558700);
    }

    public static we w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return we.z(layoutInflater, dataBindingComponent);
    }

    public static we x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return we.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static we y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (we)ViewDataBinding.inflateInternal(layoutInflater, 2131558700, viewGroup, bl2, object);
    }

    public static we z(LayoutInflater layoutInflater, Object object) {
        return (we)ViewDataBinding.inflateInternal(layoutInflater, 2131558700, null, false, object);
    }

    public abstract void A(FeedbackFragment$a var1);

    public abstract void B(o0 var1);

    public FeedbackFragment$a u() {
        return this.b;
    }

    public o0 v() {
        return this.c;
    }
}

