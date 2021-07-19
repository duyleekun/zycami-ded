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
import d.v.c.x0.b.p$b;

public abstract class j9
extends ViewDataBinding {
    public final BaseResourceListView a;
    public final StatusView b;
    public p$b c;
    public i d;

    public j9(Object object, View view, int n10, BaseResourceListView baseResourceListView, StatusView statusView) {
        super(object, view, n10);
        this.a = baseResourceListView;
        this.b = statusView;
    }

    public static j9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j9.t(view, dataBindingComponent);
    }

    public static j9 t(View view, Object object) {
        return (j9)ViewDataBinding.bind(object, view, 2131558605);
    }

    public static j9 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j9.z(layoutInflater, dataBindingComponent);
    }

    public static j9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j9.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j9)ViewDataBinding.inflateInternal(layoutInflater, 2131558605, viewGroup, bl2, object);
    }

    public static j9 z(LayoutInflater layoutInflater, Object object) {
        return (j9)ViewDataBinding.inflateInternal(layoutInflater, 2131558605, null, false, object);
    }

    public abstract void A(p$b var1);

    public abstract void B(i var1);

    public p$b u() {
        return this.c;
    }

    public i v() {
        return this.d;
    }
}

