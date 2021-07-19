/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class LogThreadPoolManager$1
implements RejectedExecutionHandler {
    public final /* synthetic */ LogThreadPoolManager this$0;

    public LogThreadPoolManager$1(LogThreadPoolManager logThreadPoolManager) {
        this.this$0 = logThreadPoolManager;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor object) {
        int n10;
        object = LogThreadPoolManager.access$000(this.this$0);
        int n11 = object.size();
        if (n11 >= (n10 = 200)) {
            object = LogThreadPoolManager.access$000(this.this$0);
            object.poll();
        }
        LogThreadPoolManager.access$000(this.this$0).offer(runnable);
    }
}

