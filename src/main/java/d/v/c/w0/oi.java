/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.VideoCropFragment$c;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.s0.a7.j1;

public abstract class oi
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ProgressBar d;
    public final ImageView e;
    public final ThumbnailView f;
    public final TextView g;
    public final TextView h;
    public final ExoVideoView i;
    public final TextView j;
    public final ProgressBar k;
    public UploadCEMediaInfo l;
    public ObservableBoolean m;
    public j1 n;
    public VideoCropFragment$c o;

    public oi(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, ProgressBar progressBar, ImageView imageView2, ThumbnailView thumbnailView, TextView textView3, TextView textView4, ExoVideoView exoVideoView, TextView textView5, ProgressBar progressBar2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = progressBar;
        this.e = imageView2;
        this.f = thumbnailView;
        this.g = textView3;
        this.h = textView4;
        this.i = exoVideoView;
        this.j = textView5;
        this.k = progressBar2;
    }

    public static oi A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (oi)ViewDataBinding.inflateInternal(layoutInflater, 2131558809, viewGroup, bl2, object);
    }

    public static oi B(LayoutInflater layoutInflater, Object object) {
        return (oi)ViewDataBinding.inflateInternal(layoutInflater, 2131558809, null, false, object);
    }

    public static oi s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oi.t(view, dataBindingComponent);
    }

    public static oi t(View view, Object object) {
        return (oi)ViewDataBinding.bind(object, view, 2131558809);
    }

    public static oi y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oi.B(layoutInflater, dataBindingComponent);
    }

    public static oi z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oi.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(VideoCropFragment$c var1);

    public abstract void D(UploadCEMediaInfo var1);

    public abstract void E(j1 var1);

    public abstract void F(ObservableBoolean var1);

    public VideoCropFragment$c u() {
        return this.o;
    }

    public UploadCEMediaInfo v() {
        return this.l;
    }

    public j1 w() {
        return this.n;
    }

    public ObservableBoolean x() {
        return this.m;
    }
}

