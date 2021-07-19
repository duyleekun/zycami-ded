/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;

public final class BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1
implements Runnable {
    public final /* synthetic */ BaseLoadMoreModule this$0;

    public BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(BaseLoadMoreModule baseLoadMoreModule) {
        this.this$0 = baseLoadMoreModule;
    }

    public final void run() {
        OnLoadMoreListener onLoadMoreListener = BaseLoadMoreModule.access$getMLoadMoreListener$p(this.this$0);
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore();
        }
    }
}

