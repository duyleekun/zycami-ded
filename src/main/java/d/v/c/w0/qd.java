/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class qd
extends ViewDataBinding {
    public final ImageView a;
    public final View b;
    public CameraFragment$j c;
    public z d;

    public qd(Object object, View view, int n10, ImageView imageView, View view2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = view2;
    }

    public static qd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qd.t(view, dataBindingComponent);
    }

    public static qd t(View view, Object object) {
        return (qd)ViewDataBinding.bind(object, view, 2131558673);
    }

    public static qd w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qd.z(layoutInflater, dataBindingComponent);
    }

    public static qd x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qd.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qd)ViewDataBinding.inflateInternal(layoutInflater, 2131558673, viewGroup, bl2, object);
    }

    public static qd z(LayoutInflater layoutInflater, Object object) {
        return (qd)ViewDataBinding.inflateInternal(layoutInflater, 2131558673, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.c;
    }

    public z v() {
        return this.d;
    }
}

