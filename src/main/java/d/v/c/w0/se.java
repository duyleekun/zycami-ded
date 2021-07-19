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
import com.zhiyun.cama.me.help.FeedbackEditAddFragment$b;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView;
import com.zhiyun.cama.me.help.view.ScrollEditText;

public abstract class se
extends ViewDataBinding {
    public final ScrollEditText a;
    public final FrameLayout b;
    public final ImageView c;
    public final AddImageRecyclerView d;
    public final TextView e;
    public final TextView f;
    public FeedbackEditAddFragment$b g;

    public se(Object object, View view, int n10, ScrollEditText scrollEditText, FrameLayout frameLayout, ImageView imageView, AddImageRecyclerView addImageRecyclerView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = scrollEditText;
        this.b = frameLayout;
        this.c = imageView;
        this.d = addImageRecyclerView;
        this.e = textView;
        this.f = textView2;
    }

    public static se s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return se.t(view, dataBindingComponent);
    }

    public static se t(View view, Object object) {
        return (se)ViewDataBinding.bind(object, view, 2131558698);
    }

    public static se v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return se.y(layoutInflater, dataBindingComponent);
    }

    public static se w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return se.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static se x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (se)ViewDataBinding.inflateInternal(layoutInflater, 2131558698, viewGroup, bl2, object);
    }

    public static se y(LayoutInflater layoutInflater, Object object) {
        return (se)ViewDataBinding.inflateInternal(layoutInflater, 2131558698, null, false, object);
    }

    public FeedbackEditAddFragment$b u() {
        return this.g;
    }

    public abstract void z(FeedbackEditAddFragment$b var1);
}

