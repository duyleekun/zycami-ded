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
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.v0.i;
import d.v.c.x0.c.f.k$a;

public abstract class l8
extends ViewDataBinding {
    public final BaseResourceListView a;
    public final StatusView b;
    public i c;
    public k$a d;

    public l8(Object object, View view, int n10, BaseResourceListView baseResourceListView, StatusView statusView) {
        super(object, view, n10);
        this.a = baseResourceListView;
        this.b = statusView;
    }

    public static l8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l8.t(view, dataBindingComponent);
    }

    public static l8 t(View view, Object object) {
        return (l8)ViewDataBinding.bind(object, view, 2131558593);
    }

    public static l8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l8.z(layoutInflater, dataBindingComponent);
    }

    public static l8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l8)ViewDataBinding.inflateInternal(layoutInflater, 2131558593, viewGroup, bl2, object);
    }

    public static l8 z(LayoutInflater layoutInflater, Object object) {
        return (l8)ViewDataBinding.inflateInternal(layoutInflater, 2131558593, null, false, object);
    }

    public abstract void A(k$a var1);

    public abstract void B(i var1);

    public k$a u() {
        return this.d;
    }

    public i v() {
        return this.c;
    }
}

