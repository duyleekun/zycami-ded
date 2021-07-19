/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.chad.library.adapter.base.module;

import android.view.View;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;

public final class BaseLoadMoreModule$setupViewHolder$1
implements View.OnClickListener {
    public final /* synthetic */ BaseLoadMoreModule this$0;

    public BaseLoadMoreModule$setupViewHolder$1(BaseLoadMoreModule baseLoadMoreModule) {
        this.this$0 = baseLoadMoreModule;
    }

    public final void onClick(View object) {
        LoadMoreStatus loadMoreStatus;
        object = this.this$0.getLoadMoreStatus();
        if (object == (loadMoreStatus = LoadMoreStatus.Fail)) {
            object = this.this$0;
            object.loadMoreToLoading();
        } else {
            object = this.this$0.getLoadMoreStatus();
            if (object == (loadMoreStatus = LoadMoreStatus.Complete)) {
                object = this.this$0;
                object.loadMoreToLoading();
            } else {
                object = this.this$0;
                boolean bl2 = object.getEnableLoadMoreEndClick();
                if (bl2 && (object = this.this$0.getLoadMoreStatus()) == (loadMoreStatus = LoadMoreStatus.End)) {
                    object = this.this$0;
                    object.loadMoreToLoading();
                }
            }
        }
    }
}

