/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.zyplayer.ExoVideoView;

public abstract class ci
extends ViewDataBinding {
    public final ExoVideoView a;
    public final FrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ProgressBar f;
    public final View g;

    public ci(Object object, View view, int n10, ExoVideoView exoVideoView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, View view2) {
        super(object, view, n10);
        this.a = exoVideoView;
        this.b = frameLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = progressBar;
        this.g = view2;
    }

    public static ci s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ci.t(view, dataBindingComponent);
    }

    public static ci t(View view, Object object) {
        return (ci)ViewDataBinding.bind(object, view, 2131558792);
    }

    public static ci u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ci.x(layoutInflater, dataBindingComponent);
    }

    public static ci v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ci.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ci w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ci)ViewDataBinding.inflateInternal(layoutInflater, 2131558792, viewGroup, bl2, object);
    }

    public static ci x(LayoutInflater layoutInflater, Object object) {
        return (ci)ViewDataBinding.inflateInternal(layoutInflater, 2131558792, null, false, object);
    }
}

