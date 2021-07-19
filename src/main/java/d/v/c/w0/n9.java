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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.widget.RetProgressBar;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.s0.a7.j1;
import d.v.c.s0.h7.s0.y$b;
import d.v.c.w0.ai;

public abstract class n9
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final Group e;
    public final Group f;
    public final Guideline g;
    public final Guideline h;
    public final Guideline i;
    public final ImageView j;
    public final ImageView k;
    public final PlayerWrapperView l;
    public final PlayerWrapperView m;
    public final RetProgressBar n;
    public final ai o;
    public final StoryProgressBar p;
    public final ZYTextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final View u;
    public y$b v;
    public StoryReviewViewModel w;
    public TemplateEditViewModel x;
    public j1 y;

    public n9(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, Group group, Group group2, Guideline guideline, Guideline guideline2, Guideline guideline3, ImageView imageView, ImageView imageView2, PlayerWrapperView playerWrapperView, PlayerWrapperView playerWrapperView2, RetProgressBar retProgressBar, ai ai2, StoryProgressBar storyProgressBar, ZYTextView zYTextView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = group;
        this.f = group2;
        this.g = guideline;
        this.h = guideline2;
        this.i = guideline3;
        this.j = imageView;
        this.k = imageView2;
        this.l = playerWrapperView;
        this.m = playerWrapperView2;
        this.n = retProgressBar;
        this.o = ai2;
        this.p = storyProgressBar;
        this.q = zYTextView;
        this.r = textView;
        this.s = textView2;
        this.t = textView3;
        this.u = view2;
    }

    public static n9 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n9)ViewDataBinding.inflateInternal(layoutInflater, 2131558607, viewGroup, bl2, object);
    }

    public static n9 B(LayoutInflater layoutInflater, Object object) {
        return (n9)ViewDataBinding.inflateInternal(layoutInflater, 2131558607, null, false, object);
    }

    public static n9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n9.t(view, dataBindingComponent);
    }

    public static n9 t(View view, Object object) {
        return (n9)ViewDataBinding.bind(object, view, 2131558607);
    }

    public static n9 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n9.B(layoutInflater, dataBindingComponent);
    }

    public static n9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n9.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(y$b var1);

    public abstract void D(j1 var1);

    public abstract void E(TemplateEditViewModel var1);

    public abstract void F(StoryReviewViewModel var1);

    public y$b u() {
        return this.v;
    }

    public j1 v() {
        return this.y;
    }

    public TemplateEditViewModel w() {
        return this.x;
    }

    public StoryReviewViewModel x() {
        return this.w;
    }
}

