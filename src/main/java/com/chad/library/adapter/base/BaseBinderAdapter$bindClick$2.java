/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.BaseBinderAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class BaseBinderAdapter$bindClick$2
implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder $viewHolder;
    public final /* synthetic */ BaseBinderAdapter this$0;

    public BaseBinderAdapter$bindClick$2(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder) {
        this.this$0 = baseBinderAdapter;
        this.$viewHolder = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int n10;
        BaseViewHolder baseViewHolder = this.$viewHolder;
        int n11 = baseViewHolder.getAdapterPosition();
        if (n11 == (n10 = -1)) {
            return false;
        }
        n10 = this.this$0.getHeaderLayoutCount();
        n11 -= n10;
        n10 = this.$viewHolder.getItemViewType();
        BaseItemBinder baseItemBinder = this.this$0.getItemBinder(n10);
        BaseViewHolder baseViewHolder2 = this.$viewHolder;
        f0.h(view, "it");
        Object e10 = this.this$0.getData().get(n11);
        return baseItemBinder.onLongClick(baseViewHolder2, view, e10, n11);
    }
}

