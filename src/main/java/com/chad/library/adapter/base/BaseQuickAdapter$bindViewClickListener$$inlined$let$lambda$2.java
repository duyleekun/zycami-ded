/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2
implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder $viewHolder$inlined;
    public final /* synthetic */ BaseQuickAdapter this$0;

    public BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.this$0 = baseQuickAdapter;
        this.$viewHolder$inlined = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int n10;
        BaseViewHolder baseViewHolder = this.$viewHolder$inlined;
        int n11 = baseViewHolder.getAdapterPosition();
        if (n11 == (n10 = -1)) {
            return false;
        }
        n10 = this.this$0.getHeaderLayoutCount();
        BaseQuickAdapter baseQuickAdapter = this.this$0;
        f0.h(view, "v");
        return baseQuickAdapter.setOnItemLongClick(view, n11 -= n10);
    }
}

