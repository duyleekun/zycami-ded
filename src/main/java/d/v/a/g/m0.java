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
import com.zhiyun.account.SimpleWebViewActivity$c;
import com.zhiyun.component.widget.JSWebView;

public abstract class m0
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final JSWebView c;
    public SimpleWebViewActivity$c d;

    public m0(Object object, View view, int n10, ImageView imageView, TextView textView, JSWebView jSWebView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = jSWebView;
    }

    public static m0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m0.t(view, dataBindingComponent);
    }

    public static m0 t(View view, Object object) {
        int n10 = R$layout.simple_webview_act;
        return (m0)ViewDataBinding.bind(object, view, n10);
    }

    public static m0 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m0.y(layoutInflater, dataBindingComponent);
    }

    public static m0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return m0.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static m0 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.simple_webview_act;
        return (m0)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static m0 y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.simple_webview_act;
        return (m0)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public SimpleWebViewActivity$c u() {
        return this.d;
    }

    public abstract void z(SimpleWebViewActivity$c var1);
}

