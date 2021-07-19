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
import com.zhiyun.cama.set.SetSupportFragment$a;

public abstract class wg
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public SetSupportFragment$a c;

    public wg(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static wg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wg.t(view, dataBindingComponent);
    }

    public static wg t(View view, Object object) {
        return (wg)ViewDataBinding.bind(object, view, 2131558767);
    }

    public static wg v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wg.y(layoutInflater, dataBindingComponent);
    }

    public static wg w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wg.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wg)ViewDataBinding.inflateInternal(layoutInflater, 2131558767, viewGroup, bl2, object);
    }

    public static wg y(LayoutInflater layoutInflater, Object object) {
        return (wg)ViewDataBinding.inflateInternal(layoutInflater, 2131558767, null, false, object);
    }

    public SetSupportFragment$a u() {
        return this.c;
    }

    public abstract void z(SetSupportFragment$a var1);
}

