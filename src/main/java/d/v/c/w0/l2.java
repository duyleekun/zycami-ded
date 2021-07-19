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
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment$b;
import com.zhiyun.zyplayer.ExoVideoView;

public abstract class l2
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;
    public final ProgressBar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ExoVideoView i;
    public String j;
    public CECompositeFinishFragment.b k;

    public l2(Object object, View view, int n10, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, ProgressBar progressBar, TextView textView2, TextView textView3, TextView textView4, ExoVideoView exoVideoView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
        this.d = imageView3;
        this.e = progressBar;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = exoVideoView;
    }

    public static l2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l2.t(view, dataBindingComponent);
    }

    public static l2 t(View view, Object object) {
        return (l2)ViewDataBinding.bind(object, view, 2131558485);
    }

    public static l2 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l2.z(layoutInflater, dataBindingComponent);
    }

    public static l2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return l2.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static l2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (l2)ViewDataBinding.inflateInternal(layoutInflater, 2131558485, viewGroup, bl2, object);
    }

    public static l2 z(LayoutInflater layoutInflater, Object object) {
        return (l2)ViewDataBinding.inflateInternal(layoutInflater, 2131558485, null, false, object);
    }

    public abstract void A(CECompositeFinishFragment.b var1);

    public abstract void B(String var1);

    public CECompositeFinishFragment.b u() {
        return this.k;
    }

    public String v() {
        return this.j;
    }
}

