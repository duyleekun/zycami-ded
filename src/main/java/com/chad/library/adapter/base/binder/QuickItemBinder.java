/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.binder;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public abstract class QuickItemBinder
extends BaseItemBinder {
    public abstract int getLayoutId();

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "parent");
        int n11 = this.getLayoutId();
        viewGroup = AdapterUtilsKt.getItemView(viewGroup, n11);
        BaseViewHolder baseViewHolder = new BaseViewHolder((View)viewGroup);
        return baseViewHolder;
    }
}

