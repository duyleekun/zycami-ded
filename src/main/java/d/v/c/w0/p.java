/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$e;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.cama.widget.MediaConstrainLayout;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.u1.k;
import d.v.c.w0.wi;

public abstract class p
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final LineProgressBar g;
    public final PlayerWrapperView h;
    public final RecyclerView i;
    public final MediaConstrainLayout j;
    public final ViewStubProxy k;
    public final wi l;
    public final View m;
    public final ThumbnailView n;
    public EditorTemplateEditActivity$e o;
    public TemplateEditViewModel p;
    public k q;

    public p(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, LineProgressBar lineProgressBar, PlayerWrapperView playerWrapperView, RecyclerView recyclerView, MediaConstrainLayout mediaConstrainLayout, ViewStubProxy viewStubProxy, wi wi2, View view2, ThumbnailView thumbnailView) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = frameLayout4;
        this.f = imageView;
        this.g = lineProgressBar;
        this.h = playerWrapperView;
        this.i = recyclerView;
        this.j = mediaConstrainLayout;
        this.k = viewStubProxy;
        this.l = wi2;
        this.m = view2;
        this.n = thumbnailView;
    }

    public static p A(LayoutInflater layoutInflater, Object object) {
        return (p)ViewDataBinding.inflateInternal(layoutInflater, 2131558437, null, false, object);
    }

    public static p s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.p.t(view, dataBindingComponent);
    }

    public static p t(View view, Object object) {
        return (p)ViewDataBinding.bind(object, view, 2131558437);
    }

    public static p x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.p.A(layoutInflater, dataBindingComponent);
    }

    public static p y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.c.w0.p.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p)ViewDataBinding.inflateInternal(layoutInflater, 2131558437, viewGroup, bl2, object);
    }

    public abstract void B(EditorTemplateEditActivity$e var1);

    public abstract void C(TemplateEditViewModel var1);

    public abstract void D(k var1);

    public EditorTemplateEditActivity$e u() {
        return this.o;
    }

    public TemplateEditViewModel v() {
        return this.p;
    }

    public k w() {
        return this.q;
    }
}

