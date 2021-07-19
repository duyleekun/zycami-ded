/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.publish.UploadCEMediaInfo;

public abstract class fa
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public Integer c;
    public ObservableInt d;
    public UploadCEMediaInfo e;

    public fa(Object object, View view, int n10, ImageView imageView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
    }

    public static fa A(LayoutInflater layoutInflater, Object object) {
        return (fa)ViewDataBinding.inflateInternal(layoutInflater, 2131558621, null, false, object);
    }

    public static fa s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return fa.t(view, dataBindingComponent);
    }

    public static fa t(View view, Object object) {
        return (fa)ViewDataBinding.bind(object, view, 2131558621);
    }

    public static fa x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return fa.A(layoutInflater, dataBindingComponent);
    }

    public static fa y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return fa.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static fa z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (fa)ViewDataBinding.inflateInternal(layoutInflater, 2131558621, viewGroup, bl2, object);
    }

    public abstract void B(ObservableInt var1);

    public abstract void C(UploadCEMediaInfo var1);

    public abstract void D(Integer var1);

    public ObservableInt u() {
        return this.d;
    }

    public UploadCEMediaInfo v() {
        return this.e;
    }

    public Integer w() {
        return this.c;
    }
}

