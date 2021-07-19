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
import com.zhiyun.cama.device.active.ActivationActivity$a;

public abstract class a
extends ViewDataBinding {
    public final ImageView a;
    public ActivationActivity$a b;

    public a(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static a s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.a.t(view, dataBindingComponent);
    }

    public static a t(View view, Object object) {
        return (a)ViewDataBinding.bind(object, view, 2131558428);
    }

    public static a v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.a.y(layoutInflater, dataBindingComponent);
    }

    public static a w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.a.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static a x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (a)ViewDataBinding.inflateInternal(layoutInflater, 2131558428, viewGroup, bl2, object);
    }

    public static a y(LayoutInflater layoutInflater, Object object) {
        return (a)ViewDataBinding.inflateInternal(layoutInflater, 2131558428, null, false, object);
    }

    public ActivationActivity$a u() {
        return this.b;
    }

    public abstract void z(ActivationActivity$a var1);
}

