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
import com.zhiyun.cama.main.EditorMainFragment$g;
import d.v.c.i1.h2;

public abstract class t4
extends ViewDataBinding {
    public EditorMainFragment$g a;
    public h2 b;

    public t4(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static t4 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t4.t(view, dataBindingComponent);
    }

    public static t4 t(View view, Object object) {
        return (t4)ViewDataBinding.bind(object, view, 2131558534);
    }

    public static t4 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t4.z(layoutInflater, dataBindingComponent);
    }

    public static t4 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t4.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t4 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t4)ViewDataBinding.inflateInternal(layoutInflater, 2131558534, viewGroup, bl2, object);
    }

    public static t4 z(LayoutInflater layoutInflater, Object object) {
        return (t4)ViewDataBinding.inflateInternal(layoutInflater, 2131558534, null, false, object);
    }

    public abstract void A(EditorMainFragment$g var1);

    public abstract void B(h2 var1);

    public EditorMainFragment$g u() {
        return this.a;
    }

    public h2 v() {
        return this.b;
    }
}

