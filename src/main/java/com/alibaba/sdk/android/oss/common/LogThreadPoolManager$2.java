/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common;

import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import java.util.concurrent.ThreadFactory;

public class LogThreadPoolManager$2
implements ThreadFactory {
    public final /* synthetic */ LogThreadPoolManager this$0;

    public LogThreadPoolManager$2(LogThreadPoolManager logThreadPoolManager) {
        this.this$0 = logThreadPoolManager;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "oss-android-log-thread");
        return thread;
    }
}

