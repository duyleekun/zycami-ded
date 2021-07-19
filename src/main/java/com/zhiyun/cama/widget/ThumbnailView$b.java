/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.widget;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.widget.ThumbnailView;

public class ThumbnailView$b
extends RecyclerView$ViewHolder {
    private ViewDataBinding a;
    public final /* synthetic */ ThumbnailView b;

    public ThumbnailView$b(ThumbnailView thumbnailView, ViewDataBinding viewDataBinding) {
        this.b = thumbnailView;
        thumbnailView = viewDataBinding.getRoot();
        super((View)thumbnailView);
        this.a = viewDataBinding;
    }

    public void a(ViewDataBinding viewDataBinding) {
        this.a = viewDataBinding;
    }

    public ViewDataBinding getBinding() {
        return this.a;
    }
}

