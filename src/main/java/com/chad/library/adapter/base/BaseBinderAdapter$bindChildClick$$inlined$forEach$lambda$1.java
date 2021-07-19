/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.BaseBinderAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1
implements View.OnClickListener {
    public final /* synthetic */ BaseItemBinder $provider$inlined;
    public final /* synthetic */ BaseViewHolder $viewHolder$inlined;
    public final /* synthetic */ BaseBinderAdapter this$0;

    public BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder, BaseItemBinder baseItemBinder) {
        this.this$0 = baseBinderAdapter;
        this.$viewHolder$inlined = baseViewHolder;
        this.$provider$inlined = baseItemBinder;
    }

    public final void onClick(View view) {
        int n10;
        BaseViewHolder baseViewHolder = this.$viewHolder$inlined;
        int n11 = baseViewHolder.getAdapterPosition();
        if (n11 == (n10 = -1)) {
            return;
        }
        n10 = this.this$0.getHeaderLayoutCount();
        BaseItemBinder baseItemBinder = this.$provider$inlined;
        BaseViewHolder baseViewHolder2 = this.$viewHolder$inlined;
        f0.h(view, "v");
        Object e10 = this.this$0.getData().get(n11 -= n10);
        baseItemBinder.onChildClick(baseViewHolder2, view, e10, n11);
    }
}

