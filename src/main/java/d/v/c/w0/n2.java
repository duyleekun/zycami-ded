/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CEDirectPublishDialog$a;

public abstract class n2
extends ViewDataBinding {
    public final TextView a;
    public final CheckBox b;
    public final TextView c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public CEDirectPublishDialog.a h;

    public n2(Object object, View view, int n10, TextView textView, CheckBox checkBox, TextView textView2, View view2, TextView textView3, TextView textView4, View view3) {
        super(object, view, n10);
        this.a = textView;
        this.b = checkBox;
        this.c = textView2;
        this.d = view2;
        this.e = textView3;
        this.f = textView4;
        this.g = view3;
    }

    public static n2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n2.t(view, dataBindingComponent);
    }

    public static n2 t(View view, Object object) {
        return (n2)ViewDataBinding.bind(object, view, 2131558486);
    }

    public static n2 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n2.y(layoutInflater, dataBindingComponent);
    }

    public static n2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n2.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n2)ViewDataBinding.inflateInternal(layoutInflater, 2131558486, viewGroup, bl2, object);
    }

    public static n2 y(LayoutInflater layoutInflater, Object object) {
        return (n2)ViewDataBinding.inflateInternal(layoutInflater, 2131558486, null, false, object);
    }

    public CEDirectPublishDialog.a u() {
        return this.h;
    }

    public abstract void z(CEDirectPublishDialog.a var1);
}

