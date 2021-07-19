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
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class sd
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final RecyclerView c;
    public final View d;
    public CameraFragment$j e;
    public z f;

    public sd(Object object, View view, int n10, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, View view2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = recyclerView;
        this.d = view2;
    }

    public static sd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sd.t(view, dataBindingComponent);
    }

    public static sd t(View view, Object object) {
        return (sd)ViewDataBinding.bind(object, view, 2131558674);
    }

    public static sd w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sd.z(layoutInflater, dataBindingComponent);
    }

    public static sd x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sd.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sd)ViewDataBinding.inflateInternal(layoutInflater, 2131558674, viewGroup, bl2, object);
    }

    public static sd z(LayoutInflater layoutInflater, Object object) {
        return (sd)ViewDataBinding.inflateInternal(layoutInflater, 2131558674, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.e;
    }

    public z v() {
        return this.f;
    }
}

