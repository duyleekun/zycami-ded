/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1
implements View.OnClickListener {
    public final /* synthetic */ BaseItemProvider $provider$inlined;
    public final /* synthetic */ BaseViewHolder $viewHolder$inlined;
    public final /* synthetic */ BaseProviderMultiAdapter this$0;

    public BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder, BaseItemProvider baseItemProvider) {
        this.this$0 = baseProviderMultiAdapter;
        this.$viewHolder$inlined = baseViewHolder;
        this.$provider$inlined = baseItemProvider;
    }

    public final void onClick(View view) {
        int n10;
        BaseViewHolder baseViewHolder = this.$viewHolder$inlined;
        int n11 = baseViewHolder.getAdapterPosition();
        if (n11 == (n10 = -1)) {
            return;
        }
        n10 = this.this$0.getHeaderLayoutCount();
        BaseItemProvider baseItemProvider = this.$provider$inlined;
        BaseViewHolder baseViewHolder2 = this.$viewHolder$inlined;
        f0.h(view, "v");
        Object e10 = this.this$0.getData().get(n11 -= n10);
        baseItemProvider.onChildClick(baseViewHolder2, view, e10, n11);
    }
}

