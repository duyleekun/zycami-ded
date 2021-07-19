/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;

public final class BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$2
implements Runnable {
    public final /* synthetic */ RecyclerView$LayoutManager $manager;
    public final /* synthetic */ BaseLoadMoreModule this$0;

    public BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$2(BaseLoadMoreModule baseLoadMoreModule, RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.this$0 = baseLoadMoreModule;
        this.$manager = recyclerView$LayoutManager;
    }

    public final void run() {
        Object object = new int[((StaggeredGridLayoutManager)this.$manager).getSpanCount()];
        ((StaggeredGridLayoutManager)this.$manager).findLastCompletelyVisibleItemPositions((int[])object);
        BaseLoadMoreModule baseLoadMoreModule = this.this$0;
        int n10 = BaseLoadMoreModule.access$getTheBiggestNumber(baseLoadMoreModule, object);
        int n11 = 1;
        BaseQuickAdapter baseQuickAdapter = BaseLoadMoreModule.access$getBaseQuickAdapter$p(this.this$0);
        int n12 = baseQuickAdapter.getItemCount();
        if ((n10 += n11) != n12) {
            object = this.this$0;
            BaseLoadMoreModule.access$setMNextLoadEnable$p((BaseLoadMoreModule)object, n11 != 0);
        }
    }
}

