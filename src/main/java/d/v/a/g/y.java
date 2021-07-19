/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.EditText
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;

public abstract class y
extends ViewDataBinding {
    public final CheckBox a;
    public final EditText b;

    public y(Object object, View view, int n10, CheckBox checkBox, EditText editText) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = editText;
    }

    public static y s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return y.t(view, dataBindingComponent);
    }

    public static y t(View view, Object object) {
        int n10 = R$layout.me_pass_view;
        return (y)ViewDataBinding.bind(object, view, n10);
    }

    public static y u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return y.x(layoutInflater, dataBindingComponent);
    }

    public static y v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return y.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static y w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_pass_view;
        return (y)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static y x(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_pass_view;
        return (y)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }
}

