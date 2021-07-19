/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import com.zhiyun.cama.cloud_engine.CETemplatePreviewDialog$a;
import com.zhiyun.zyplayer.ExoVideoView;

public abstract class r2
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final ExoVideoView g;
    public final FrameLayout h;
    public CETemplateModel i;
    public ObservableBoolean j;
    public CETemplatePreviewDialog.a k;

    public r2(Object object, View view, int n10, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, ExoVideoView exoVideoView, FrameLayout frameLayout) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = imageView2;
        this.e = textView3;
        this.f = textView4;
        this.g = exoVideoView;
        this.h = frameLayout;
    }

    public static r2 A(LayoutInflater layoutInflater, Object object) {
        return (r2)ViewDataBinding.inflateInternal(layoutInflater, 2131558489, null, false, object);
    }

    public static r2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r2.t(view, dataBindingComponent);
    }

    public static r2 t(View view, Object object) {
        return (r2)ViewDataBinding.bind(object, view, 2131558489);
    }

    public static r2 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r2.A(layoutInflater, dataBindingComponent);
    }

    public static r2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r2.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r2 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r2)ViewDataBinding.inflateInternal(layoutInflater, 2131558489, viewGroup, bl2, object);
    }

    public abstract void B(CETemplatePreviewDialog.a var1);

    public abstract void C(CETemplateModel var1);

    public abstract void D(ObservableBoolean var1);

    public CETemplatePreviewDialog.a u() {
        return this.k;
    }

    public CETemplateModel v() {
        return this.i;
    }

    public ObservableBoolean w() {
        return this.j;
    }
}

