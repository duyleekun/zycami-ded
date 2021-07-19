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
import com.zhiyun.cama.album.AlbumSection;

public abstract class ka
extends ViewDataBinding {
    public final ImageView a;
    public final View b;
    public final TextView c;
    public AlbumSection d;

    public ka(Object object, View view, int n10, ImageView imageView, View view2, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = view2;
        this.c = textView;
    }

    public static ka s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ka.t(view, dataBindingComponent);
    }

    public static ka t(View view, Object object) {
        return (ka)ViewDataBinding.bind(object, view, 2131558623);
    }

    public static ka v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ka.y(layoutInflater, dataBindingComponent);
    }

    public static ka w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ka.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ka x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ka)ViewDataBinding.inflateInternal(layoutInflater, 2131558623, viewGroup, bl2, object);
    }

    public static ka y(LayoutInflater layoutInflater, Object object) {
        return (ka)ViewDataBinding.inflateInternal(layoutInflater, 2131558623, null, false, object);
    }

    public AlbumSection u() {
        return this.d;
    }

    public abstract void z(AlbumSection var1);
}

