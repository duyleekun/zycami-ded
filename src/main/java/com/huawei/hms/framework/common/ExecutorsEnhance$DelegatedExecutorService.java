/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsEnhance$DelegatedExecutorService
extends AbstractExecutorService {
    private final ExecutorService e;

    public ExecutorsEnhance$DelegatedExecutorService(ExecutorService executorService) {
        this.e = executorService;
    }

    public boolean awaitTermination(long l10, TimeUnit timeUnit) {
        return this.e.awaitTermination(l10, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.e.execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.e.invokeAll(collection);
    }

    public List invokeAll(Collection collection, long l10, TimeUnit timeUnit) {
        return this.e.invokeAll(collection, l10, timeUnit);
    }

    public Object invokeAny(Collection collection) {
        return this.e.invokeAny(collection);
    }

    public Object invokeAny(Collection collection, long l10, TimeUnit timeUnit) {
        return this.e.invokeAny(collection, l10, timeUnit);
    }

    public boolean isShutdown() {
        return this.e.isShutdown();
    }

    public boolean isTerminated() {
        return this.e.isTerminated();
    }

    public void shutdown() {
        this.e.shutdown();
    }

    public List shutdownNow() {
        return this.e.shutdownNow();
    }

    public Future submit(Runnable runnable) {
        return this.e.submit(runnable);
    }

    public Future submit(Runnable runnable, Object object) {
        return this.e.submit(runnable, object);
    }

    public Future submit(Callable callable) {
        return this.e.submit(callable);
    }
}

