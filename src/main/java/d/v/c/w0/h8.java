/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.BackEditText;
import d.v.c.x0.c.e.b$a;

public abstract class h8
extends ViewDataBinding {
    public final BackEditText a;
    public final TextView b;
    public final View c;
    public b$a d;

    public h8(Object object, View view, int n10, BackEditText backEditText, TextView textView, View view2) {
        super(object, view, n10);
        this.a = backEditText;
        this.b = textView;
        this.c = view2;
    }

    public static h8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h8.t(view, dataBindingComponent);
    }

    public static h8 t(View view, Object object) {
        return (h8)ViewDataBinding.bind(object, view, 2131558591);
    }

    public static h8 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h8.y(layoutInflater, dataBindingComponent);
    }

    public static h8 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h8.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h8)ViewDataBinding.inflateInternal(layoutInflater, 2131558591, viewGroup, bl2, object);
    }

    public static h8 y(LayoutInflater layoutInflater, Object object) {
        return (h8)ViewDataBinding.inflateInternal(layoutInflater, 2131558591, null, false, object);
    }

    public b$a u() {
        return this.d;
    }

    public abstract void z(b$a var1);
}

