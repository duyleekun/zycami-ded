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
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;

public abstract class wf
extends ViewDataBinding {
    public final TextView a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public BindDeviceInfo e;

    public wf(Object object, View view, int n10, TextView textView, View view2, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = textView;
        this.b = view2;
        this.c = textView2;
        this.d = textView3;
    }

    public static wf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wf.t(view, dataBindingComponent);
    }

    public static wf t(View view, Object object) {
        return (wf)ViewDataBinding.bind(object, view, 2131558719);
    }

    public static wf v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wf.y(layoutInflater, dataBindingComponent);
    }

    public static wf w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wf.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wf x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wf)ViewDataBinding.inflateInternal(layoutInflater, 2131558719, viewGroup, bl2, object);
    }

    public static wf y(LayoutInflater layoutInflater, Object object) {
        return (wf)ViewDataBinding.inflateInternal(layoutInflater, 2131558719, null, false, object);
    }

    public BindDeviceInfo u() {
        return this.e;
    }

    public abstract void z(BindDeviceInfo var1);
}

