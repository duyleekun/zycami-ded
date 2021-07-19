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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.zyplayer.ExoVideoView;

public abstract class p1
extends ViewDataBinding {
    public final ExoVideoView a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;

    public p1(Object object, View view, int n10, ExoVideoView exoVideoView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = exoVideoView;
        this.b = constraintLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = textView;
        this.g = textView2;
    }

    public static p1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p1.t(view, dataBindingComponent);
    }

    public static p1 t(View view, Object object) {
        return (p1)ViewDataBinding.bind(object, view, 2131558474);
    }

    public static p1 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p1.x(layoutInflater, dataBindingComponent);
    }

    public static p1 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p1.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p1 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p1)ViewDataBinding.inflateInternal(layoutInflater, 2131558474, viewGroup, bl2, object);
    }

    public static p1 x(LayoutInflater layoutInflater, Object object) {
        return (p1)ViewDataBinding.inflateInternal(layoutInflater, 2131558474, null, false, object);
    }
}

