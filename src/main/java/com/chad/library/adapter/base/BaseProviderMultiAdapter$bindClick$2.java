/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class BaseProviderMultiAdapter$bindClick$2
implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder $viewHolder;
    public final /* synthetic */ BaseProviderMultiAdapter this$0;

    public BaseProviderMultiAdapter$bindClick$2(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder) {
        this.this$0 = baseProviderMultiAdapter;
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
        BaseItemProvider baseItemProvider = (BaseItemProvider)BaseProviderMultiAdapter.access$getMItemProviders$p(this.this$0).get(n10);
        BaseViewHolder baseViewHolder2 = this.$viewHolder;
        f0.h(view, "it");
        Object e10 = this.this$0.getData().get(n11);
        return baseItemProvider.onLongClick(baseViewHolder2, view, e10, n11);
    }
}

