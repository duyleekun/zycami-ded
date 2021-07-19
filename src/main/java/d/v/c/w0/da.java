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
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.publish.UploadCEMediaInfo;

public abstract class da
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public UploadCEMediaInfo d;

    public da(Object object, View view, int n10, ImageView imageView, ImageView imageView2, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
    }

    public static da s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return da.t(view, dataBindingComponent);
    }

    public static da t(View view, Object object) {
        return (da)ViewDataBinding.bind(object, view, 2131558620);
    }

    public static da v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return da.y(layoutInflater, dataBindingComponent);
    }

    public static da w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return da.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static da x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (da)ViewDataBinding.inflateInternal(layoutInflater, 2131558620, viewGroup, bl2, object);
    }

    public static da y(LayoutInflater layoutInflater, Object object) {
        return (da)ViewDataBinding.inflateInternal(layoutInflater, 2131558620, null, false, object);
    }

    public UploadCEMediaInfo u() {
        return this.d;
    }

    public abstract void z(UploadCEMediaInfo var1);
}

