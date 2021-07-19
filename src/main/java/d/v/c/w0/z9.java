/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.cama.album.ZYSubsamplingScaleImageView;
import com.zhiyun.cama.widget.ZYTextView;

public abstract class z9
extends ViewDataBinding {
    public final ZYSubsamplingScaleImageView a;
    public final ImageView b;
    public final ZYTextView c;
    public final AppCompatSeekBar d;
    public final ZYTextView e;
    public final VideoView f;
    public final ImageView g;
    public final ImageView h;
    public ObservableBoolean i;
    public ObservableBoolean j;
    public AlbumSection k;

    public z9(Object object, View view, int n10, ZYSubsamplingScaleImageView zYSubsamplingScaleImageView, ImageView imageView, ZYTextView zYTextView, AppCompatSeekBar appCompatSeekBar, ZYTextView zYTextView2, VideoView videoView, ImageView imageView2, ImageView imageView3) {
        super(object, view, n10);
        this.a = zYSubsamplingScaleImageView;
        this.b = imageView;
        this.c = zYTextView;
        this.d = appCompatSeekBar;
        this.e = zYTextView2;
        this.f = videoView;
        this.g = imageView2;
        this.h = imageView3;
    }

    public static z9 A(LayoutInflater layoutInflater, Object object) {
        return (z9)ViewDataBinding.inflateInternal(layoutInflater, 2131558618, null, false, object);
    }

    public static z9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z9.t(view, dataBindingComponent);
    }

    public static z9 t(View view, Object object) {
        return (z9)ViewDataBinding.bind(object, view, 2131558618);
    }

    public static z9 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z9.A(layoutInflater, dataBindingComponent);
    }

    public static z9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z9.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z9)ViewDataBinding.inflateInternal(layoutInflater, 2131558618, viewGroup, bl2, object);
    }

    public abstract void B(ObservableBoolean var1);

    public abstract void C(ObservableBoolean var1);

    public abstract void D(AlbumSection var1);

    public ObservableBoolean u() {
        return this.j;
    }

    public ObservableBoolean v() {
        return this.i;
    }

    public AlbumSection w() {
        return this.k;
    }
}

