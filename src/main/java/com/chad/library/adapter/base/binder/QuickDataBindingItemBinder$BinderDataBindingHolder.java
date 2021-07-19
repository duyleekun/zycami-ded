/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.chad.library.adapter.base.binder;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class QuickDataBindingItemBinder$BinderDataBindingHolder
extends BaseViewHolder {
    private final ViewDataBinding dataBinding;

    public QuickDataBindingItemBinder$BinderDataBindingHolder(ViewDataBinding viewDataBinding) {
        f0.q(viewDataBinding, "dataBinding");
        View view = viewDataBinding.getRoot();
        f0.h(view, "dataBinding.root");
        super(view);
        this.dataBinding = viewDataBinding;
    }

    public final ViewDataBinding getDataBinding() {
        return this.dataBinding;
    }
}

