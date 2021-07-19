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
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.d1.h;
import d.v.c.s0.h7.s0.y$b;
import d.v.c.z1.e;

public abstract class ai
extends ViewDataBinding {
    public final View a;
    public final ImageView b;
    public final RecyclerView c;
    public final RecyclerView d;
    public final FrameLayout e;
    public final PlayerWrapperView f;
    public final StoryProgressBar g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public y.b m;
    public StoryReviewViewModel n;
    public h o;
    public e p;
    public TemplateEditViewModel q;

    public ai(Object object, View view, int n10, View view2, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2, FrameLayout frameLayout, PlayerWrapperView playerWrapperView, StoryProgressBar storyProgressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3) {
        super(object, view, n10);
        this.a = view2;
        this.b = imageView;
        this.c = recyclerView;
        this.d = recyclerView2;
        this.e = frameLayout;
        this.f = playerWrapperView;
        this.g = storyProgressBar;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = view3;
    }

    public static ai A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ai.B(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ai B(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ai)ViewDataBinding.inflateInternal(layoutInflater, 2131558791, viewGroup, bl2, object);
    }

    public static ai C(LayoutInflater layoutInflater, Object object) {
        return (ai)ViewDataBinding.inflateInternal(layoutInflater, 2131558791, null, false, object);
    }

    public static ai s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ai.t(view, dataBindingComponent);
    }

    public static ai t(View view, Object object) {
        return (ai)ViewDataBinding.bind(object, view, 2131558791);
    }

    public static ai z(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ai.C(layoutInflater, dataBindingComponent);
    }

    public abstract void D(y.b var1);

    public abstract void E(h var1);

    public abstract void F(TemplateEditViewModel var1);

    public abstract void G(StoryReviewViewModel var1);

    public abstract void H(e var1);

    public y.b u() {
        return this.m;
    }

    public h v() {
        return this.o;
    }

    public TemplateEditViewModel w() {
        return this.q;
    }

    public StoryReviewViewModel x() {
        return this.n;
    }

    public e y() {
        return this.p;
    }
}

