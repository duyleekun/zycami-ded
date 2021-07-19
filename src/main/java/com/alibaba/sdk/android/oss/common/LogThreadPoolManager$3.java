/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import java.util.concurrent.ThreadPoolExecutor;

public class LogThreadPoolManager$3
implements Runnable {
    public final /* synthetic */ LogThreadPoolManager this$0;

    public LogThreadPoolManager$3(LogThreadPoolManager logThreadPoolManager) {
        this.this$0 = logThreadPoolManager;
    }

    public void run() {
        Object object = this.this$0;
        boolean bl2 = LogThreadPoolManager.access$100((LogThreadPoolManager)object);
        if (bl2) {
            object = LogThreadPoolManager.access$200(this.this$0);
            Runnable runnable = (Runnable)LogThreadPoolManager.access$000(this.this$0).poll();
            ((ThreadPoolExecutor)object).execute(runnable);
        }
    }
}

