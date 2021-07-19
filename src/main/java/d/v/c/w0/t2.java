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
import com.zhiyun.cama.cloud_engine.CEVideoSizeDialog$a;

public abstract class t2
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public CEVideoSizeDialog.a f;

    public t2(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static t2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t2.t(view, dataBindingComponent);
    }

    public static t2 t(View view, Object object) {
        return (t2)ViewDataBinding.bind(object, view, 2131558490);
    }

    public static t2 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t2.y(layoutInflater, dataBindingComponent);
    }

    public static t2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t2.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t2)ViewDataBinding.inflateInternal(layoutInflater, 2131558490, viewGroup, bl2, object);
    }

    public static t2 y(LayoutInflater layoutInflater, Object object) {
        return (t2)ViewDataBinding.inflateInternal(layoutInflater, 2131558490, null, false, object);
    }

    public CEVideoSizeDialog.a u() {
        return this.f;
    }

    public abstract void z(CEVideoSizeDialog.a var1);
}

