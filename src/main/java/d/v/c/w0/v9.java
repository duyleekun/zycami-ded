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

public abstract class v9
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public AlbumSection f;

    public v9(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = textView;
        this.e = textView2;
    }

    public static v9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v9.t(view, dataBindingComponent);
    }

    public static v9 t(View view, Object object) {
        return (v9)ViewDataBinding.bind(object, view, 2131558616);
    }

    public static v9 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v9.y(layoutInflater, dataBindingComponent);
    }

    public static v9 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v9.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v9 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v9)ViewDataBinding.inflateInternal(layoutInflater, 2131558616, viewGroup, bl2, object);
    }

    public static v9 y(LayoutInflater layoutInflater, Object object) {
        return (v9)ViewDataBinding.inflateInternal(layoutInflater, 2131558616, null, false, object);
    }

    public AlbumSection u() {
        return this.f;
    }

    public abstract void z(AlbumSection var1);
}

