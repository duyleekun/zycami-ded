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
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.h.e.a;

public abstract class oc
extends ViewDataBinding {
    public final RoundImageView a;
    public Integer b;
    public a c;
    public TemplateEditViewModel d;

    public oc(Object object, View view, int n10, RoundImageView roundImageView) {
        super(object, view, n10);
        this.a = roundImageView;
    }

    public static oc A(LayoutInflater layoutInflater, Object object) {
        return (oc)ViewDataBinding.inflateInternal(layoutInflater, 2131558652, null, false, object);
    }

    public static oc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oc.t(view, dataBindingComponent);
    }

    public static oc t(View view, Object object) {
        return (oc)ViewDataBinding.bind(object, view, 2131558652);
    }

    public static oc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oc.A(layoutInflater, dataBindingComponent);
    }

    public static oc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static oc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (oc)ViewDataBinding.inflateInternal(layoutInflater, 2131558652, viewGroup, bl2, object);
    }

    public abstract void B(a var1);

    public abstract void C(Integer var1);

    public abstract void D(TemplateEditViewModel var1);

    public a u() {
        return this.c;
    }

    public Integer v() {
        return this.b;
    }

    public TemplateEditViewModel w() {
        return this.d;
    }
}

