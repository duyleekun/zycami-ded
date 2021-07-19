/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.widget.MeNameView$b;

public abstract class w
extends ViewDataBinding {
    public final EditText a;
    public final ImageView b;
    public final TextView c;
    public MeNameView$b d;

    public w(Object object, View view, int n10, EditText editText, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = editText;
        this.b = imageView;
        this.c = textView;
    }

    public static w s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return w.t(view, dataBindingComponent);
    }

    public static w t(View view, Object object) {
        int n10 = R$layout.me_name_view;
        return (w)ViewDataBinding.bind(object, view, n10);
    }

    public static w v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return w.y(layoutInflater, dataBindingComponent);
    }

    public static w w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return w.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static w x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_name_view;
        return (w)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static w y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_name_view;
        return (w)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public MeNameView$b u() {
        return this.d;
    }

    public abstract void z(MeNameView$b var1);
}

