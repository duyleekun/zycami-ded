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
import d.v.c.x0.c.d.j$a;
import d.v.c.x0.c.d.l;

public abstract class f8
extends ViewDataBinding {
    public final BaseResourceListView a;
    public final StatusView b;
    public l c;
    public i d;
    public j$a e;

    public f8(Object object, View view, int n10, BaseResourceListView baseResourceListView, StatusView statusView) {
        super(object, view, n10);
        this.a = baseResourceListView;
        this.b = statusView;
    }

    public static f8 A(LayoutInflater layoutInflater, Object object) {
        return (f8)ViewDataBinding.inflateInternal(layoutInflater, 2131558590, null, false, object);
    }

    public static f8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f8.t(view, dataBindingComponent);
    }

    public static f8 t(View view, Object object) {
        return (f8)ViewDataBinding.bind(object, view, 2131558590);
    }

    public static f8 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f8.A(layoutInflater, dataBindingComponent);
    }

    public static f8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f8.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f8 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f8)ViewDataBinding.inflateInternal(layoutInflater, 2131558590, viewGroup, bl2, object);
    }

    public abstract void B(j$a var1);

    public abstract void C(i var1);

    public abstract void D(l var1);

    public j$a u() {
        return this.e;
    }

    public i v() {
        return this.d;
    }

    public l w() {
        return this.c;
    }
}

