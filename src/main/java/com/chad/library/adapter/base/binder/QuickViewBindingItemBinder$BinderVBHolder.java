/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.chad.library.adapter.base.binder;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class QuickViewBindingItemBinder$BinderVBHolder
extends BaseViewHolder {
    private final ViewBinding viewBinding;

    public QuickViewBindingItemBinder$BinderVBHolder(ViewBinding viewBinding) {
        f0.q(viewBinding, "viewBinding");
        View view = viewBinding.getRoot();
        f0.h(view, "viewBinding.root");
        super(view);
        this.viewBinding = viewBinding;
    }

    public final ViewBinding getViewBinding() {
        return this.viewBinding;
    }
}

