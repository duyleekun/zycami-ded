/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class kd
extends ViewDataBinding {
    public final EditText a;
    public final EditText b;
    public final ImageView c;
    public final ImageView d;
    public final View e;
    public CameraFragment$j f;
    public z g;

    public kd(Object object, View view, int n10, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, View view2) {
        super(object, view, n10);
        this.a = editText;
        this.b = editText2;
        this.c = imageView;
        this.d = imageView2;
        this.e = view2;
    }

    public static kd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kd.t(view, dataBindingComponent);
    }

    public static kd t(View view, Object object) {
        return (kd)ViewDataBinding.bind(object, view, 2131558670);
    }

    public static kd w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kd.z(layoutInflater, dataBindingComponent);
    }

    public static kd x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return kd.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static kd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (kd)ViewDataBinding.inflateInternal(layoutInflater, 2131558670, viewGroup, bl2, object);
    }

    public static kd z(LayoutInflater layoutInflater, Object object) {
        return (kd)ViewDataBinding.inflateInternal(layoutInflater, 2131558670, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.f;
    }

    public z v() {
        return this.g;
    }
}

