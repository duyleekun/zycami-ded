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
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import d.v.c.s0.h7.q0.x$a;
import d.v.c.s0.h7.q0.z;

public abstract class eh
extends ViewDataBinding {
    public final ProgressBar a;
    public final FrameLayout b;
    public final StoryReviewVideoView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final ImageView j;
    public z k;
    public x.a l;

    public eh(Object object, View view, int n10, ProgressBar progressBar, FrameLayout frameLayout, StoryReviewVideoView storyReviewVideoView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, ImageView imageView) {
        super(object, view, n10);
        this.a = progressBar;
        this.b = frameLayout;
        this.c = storyReviewVideoView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
        this.i = view2;
        this.j = imageView;
    }

    public static eh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eh.t(view, dataBindingComponent);
    }

    public static eh t(View view, Object object) {
        return (eh)ViewDataBinding.bind(object, view, 2131558780);
    }

    public static eh w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eh.z(layoutInflater, dataBindingComponent);
    }

    public static eh x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eh.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static eh y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (eh)ViewDataBinding.inflateInternal(layoutInflater, 2131558780, viewGroup, bl2, object);
    }

    public static eh z(LayoutInflater layoutInflater, Object object) {
        return (eh)ViewDataBinding.inflateInternal(layoutInflater, 2131558780, null, false, object);
    }

    public abstract void A(x.a var1);

    public abstract void B(z var1);

    public x.a u() {
        return this.l;
    }

    public z v() {
        return this.k;
    }
}

