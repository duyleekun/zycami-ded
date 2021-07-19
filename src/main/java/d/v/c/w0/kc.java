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
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.s0.h7.m0;

public abstract class kc
extends ViewDataBinding {
    public m0 a;
    public TemplateData b;
    public Integer c;

    public kc(Object object, View view, int n10) {
        super(object, view, n10);
    }

    public static kc A(LayoutInflater layoutInflater, Object object) {
        return (kc)ViewDataBinding.inflateInternal(layoutInflater, 2131558649, null, false, object);
    }

    public static kc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kc.t(view, dataBindingComponent);
    }

    public static kc t(View view, Object object) {
        return (kc)ViewDataBinding.bind(object, view, 2131558649);
    }

    public static kc x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kc.A(layoutInflater, dataBindingComponent);
    }

    public static kc y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kc.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static kc z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kc)ViewDataBinding.inflateInternal(layoutInflater, 2131558649, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(TemplateData var1);

    public abstract void D(m0 var1);

    public Integer u() {
        return this.c;
    }

    public TemplateData v() {
        return this.b;
    }

    public m0 w() {
        return this.a;
    }
}

