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
import com.zhiyun.cama.data.database.model.music.AlbumData;

public abstract class sb
extends ViewDataBinding {
    public final ImageView a;
    public AlbumData b;

    public sb(Object object, View view, int n10, ImageView imageView) {
        super(object, view, n10);
        this.a = imageView;
    }

    public static sb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sb.t(view, dataBindingComponent);
    }

    public static sb t(View view, Object object) {
        return (sb)ViewDataBinding.bind(object, view, 2131558640);
    }

    public static sb v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sb.y(layoutInflater, dataBindingComponent);
    }

    public static sb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return sb.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static sb x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (sb)ViewDataBinding.inflateInternal(layoutInflater, 2131558640, viewGroup, bl2, object);
    }

    public static sb y(LayoutInflater layoutInflater, Object object) {
        return (sb)ViewDataBinding.inflateInternal(layoutInflater, 2131558640, null, false, object);
    }

    public AlbumData u() {
        return this.b;
    }

    public abstract void z(AlbumData var1);
}

