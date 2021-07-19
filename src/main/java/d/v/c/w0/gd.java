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
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.z1.e;

public abstract class gd
extends ViewDataBinding {
    public final RoundImageView a;
    public final View b;
    public WaterMarkBean$WaterMarkDataInfo c;
    public Integer d;
    public e e;

    public gd(Object object, View view, int n10, RoundImageView roundImageView, View view2) {
        super(object, view, n10);
        this.a = roundImageView;
        this.b = view2;
    }

    public static gd A(LayoutInflater layoutInflater, Object object) {
        return (gd)ViewDataBinding.inflateInternal(layoutInflater, 2131558662, null, false, object);
    }

    public static gd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gd.t(view, dataBindingComponent);
    }

    public static gd t(View view, Object object) {
        return (gd)ViewDataBinding.bind(object, view, 2131558662);
    }

    public static gd x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gd.A(layoutInflater, dataBindingComponent);
    }

    public static gd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gd.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gd z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gd)ViewDataBinding.inflateInternal(layoutInflater, 2131558662, viewGroup, bl2, object);
    }

    public abstract void B(Integer var1);

    public abstract void C(e var1);

    public abstract void D(WaterMarkBean$WaterMarkDataInfo var1);

    public Integer u() {
        return this.d;
    }

    public e v() {
        return this.e;
    }

    public WaterMarkBean$WaterMarkDataInfo w() {
        return this.c;
    }
}

