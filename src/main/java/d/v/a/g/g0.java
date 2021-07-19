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
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.set.privacy.ChooseModifyPassFragment$a;

public abstract class g0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public ChooseModifyPassFragment$a c;

    public g0(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static g0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g0.t(view, dataBindingComponent);
    }

    public static g0 t(View view, Object object) {
        int n10 = R$layout.set_private_choose_modify_pass;
        return (g0)ViewDataBinding.bind(object, view, n10);
    }

    public static g0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g0.y(layoutInflater, dataBindingComponent);
    }

    public static g0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return g0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static g0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.set_private_choose_modify_pass;
        return (g0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static g0 y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.set_private_choose_modify_pass;
        return (g0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public ChooseModifyPassFragment$a u() {
        return this.c;
    }

    public abstract void z(ChooseModifyPassFragment$a var1);
}

