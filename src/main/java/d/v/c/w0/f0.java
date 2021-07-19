/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.main.view.LoadMoreView;

public abstract class f0
extends ViewDataBinding {
    public final LoadMoreView a;

    public f0(Object object, View view, int n10, LoadMoreView loadMoreView) {
        super(object, view, n10);
        this.a = loadMoreView;
    }

    public static f0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f0.t(view, dataBindingComponent);
    }

    public static f0 t(View view, Object object) {
        return (f0)ViewDataBinding.bind(object, view, 2131558453);
    }

    public static f0 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f0.x(layoutInflater, dataBindingComponent);
    }

    public static f0 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f0.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f0)ViewDataBinding.inflateInternal(layoutInflater, 2131558453, viewGroup, bl2, object);
    }

    public static f0 x(LayoutInflater layoutInflater, Object object) {
        return (f0)ViewDataBinding.inflateInternal(layoutInflater, 2131558453, null, false, object);
    }
}

