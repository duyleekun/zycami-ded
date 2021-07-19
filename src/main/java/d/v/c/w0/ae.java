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
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.zyplayer.ExoVideoView;

public abstract class ae
extends ViewDataBinding {
    public final ExoVideoView a;
    public final FrameLayout b;
    public final ImageView c;
    public final LineProgressBar d;
    public final ProgressBar e;

    public ae(Object object, View view, int n10, ExoVideoView exoVideoView, FrameLayout frameLayout, ImageView imageView, LineProgressBar lineProgressBar, ProgressBar progressBar) {
        super(object, view, n10);
        this.a = exoVideoView;
        this.b = frameLayout;
        this.c = imageView;
        this.d = lineProgressBar;
        this.e = progressBar;
    }

    public static ae s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ae.t(view, dataBindingComponent);
    }

    public static ae t(View view, Object object) {
        return (ae)ViewDataBinding.bind(object, view, 2131558678);
    }

    public static ae u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ae.x(layoutInflater, dataBindingComponent);
    }

    public static ae v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ae.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ae w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ae)ViewDataBinding.inflateInternal(layoutInflater, 2131558678, viewGroup, bl2, object);
    }

    public static ae x(LayoutInflater layoutInflater, Object object) {
        return (ae)ViewDataBinding.inflateInternal(layoutInflater, 2131558678, null, false, object);
    }
}

