/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;

public final class BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1
implements Runnable {
    public final /* synthetic */ RecyclerView$LayoutManager $manager;
    public final /* synthetic */ BaseLoadMoreModule this$0;

    public BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1(BaseLoadMoreModule baseLoadMoreModule, RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.this$0 = baseLoadMoreModule;
        this.$manager = recyclerView$LayoutManager;
    }

    public final void run() {
        BaseLoadMoreModule baseLoadMoreModule = this.this$0;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.$manager;
        boolean bl2 = BaseLoadMoreModule.access$isFullScreen(baseLoadMoreModule, linearLayoutManager);
        if (bl2) {
            baseLoadMoreModule = this.this$0;
            boolean bl3 = true;
            BaseLoadMoreModule.access$setMNextLoadEnable$p(baseLoadMoreModule, bl3);
        }
    }
}

