/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;

public abstract class u
extends ViewDataBinding {
    public final Button a;
    public final EditText b;

    public u(Object object, View view, int n10, Button button, EditText editText) {
        super(object, view, n10);
        this.a = button;
        this.b = editText;
    }

    public static u s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return u.t(view, dataBindingComponent);
    }

    public static u t(View view, Object object) {
        int n10 = R$layout.me_get_code_view;
        return (u)ViewDataBinding.bind(object, view, n10);
    }

    public static u u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return u.x(layoutInflater, dataBindingComponent);
    }

    public static u v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return u.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static u w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_get_code_view;
        return (u)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static u x(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_get_code_view;
        return (u)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }
}

