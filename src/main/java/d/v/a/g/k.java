/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;

public abstract class k
extends ViewDataBinding {
    public final TextView a;

    public k(Object object, View view, int n10, TextView textView) {
        super(object, view, n10);
        this.a = textView;
    }

    public static k s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k.t(view, dataBindingComponent);
    }

    public static k t(View view, Object object) {
        int n10 = R$layout.me_account_self_login_dialog;
        return (k)ViewDataBinding.bind(object, view, n10);
    }

    public static k u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k.x(layoutInflater, dataBindingComponent);
    }

    public static k v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return k.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static k w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_account_self_login_dialog;
        return (k)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static k x(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_account_self_login_dialog;
        return (k)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }
}

