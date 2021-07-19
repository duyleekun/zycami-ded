/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors$Application;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MoreExecutors$Application$1
implements Runnable {
    public final /* synthetic */ MoreExecutors.Application this$0;
    public final /* synthetic */ ExecutorService val$service;
    public final /* synthetic */ long val$terminationTimeout;
    public final /* synthetic */ TimeUnit val$timeUnit;

    public MoreExecutors$Application$1(MoreExecutors.Application application, ExecutorService executorService, long l10, TimeUnit timeUnit) {
        this.this$0 = application;
        this.val$service = executorService;
        this.val$terminationTimeout = l10;
        this.val$timeUnit = timeUnit;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        ExecutorService executorService;
        try {
            executorService = this.val$service;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
        executorService.shutdown();
        executorService = this.val$service;
        long l10 = this.val$terminationTimeout;
        TimeUnit timeUnit = this.val$timeUnit;
        executorService.awaitTermination(l10, timeUnit);
    }
}

