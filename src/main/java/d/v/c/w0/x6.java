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
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import d.v.c.v0.i;
import d.v.c.y1.f.v.j$a;
import d.v.c.y1.f.v.l;

public abstract class x6
extends ViewDataBinding {
    public final RecyclerView a;
    public final StatusView b;
    public l c;
    public i d;
    public j$a e;

    public x6(Object object, View view, int n10, RecyclerView recyclerView, StatusView statusView) {
        super(object, view, n10);
        this.a = recyclerView;
        this.b = statusView;
    }

    public static x6 A(LayoutInflater layoutInflater, Object object) {
        return (x6)ViewDataBinding.inflateInternal(layoutInflater, 2131558574, null, false, object);
    }

    public static x6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x6.t(view, dataBindingComponent);
    }

    public static x6 t(View view, Object object) {
        return (x6)ViewDataBinding.bind(object, view, 2131558574);
    }

    public static x6 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x6.A(layoutInflater, dataBindingComponent);
    }

    public static x6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x6.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x6 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x6)ViewDataBinding.inflateInternal(layoutInflater, 2131558574, viewGroup, bl2, object);
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

