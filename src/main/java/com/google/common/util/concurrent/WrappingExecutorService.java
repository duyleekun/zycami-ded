/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.util.concurrent.WrappingExecutorService$1;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class WrappingExecutorService
implements ExecutorService {
    private final ExecutorService delegate;

    public WrappingExecutorService(ExecutorService executorService) {
        this.delegate = executorService = (ExecutorService)Preconditions.checkNotNull(executorService);
    }

    private ImmutableList wrapTasks(Collection object) {
        boolean bl2;
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Callable callable = (Callable)object.next();
            callable = this.wrapTask(callable);
            immutableList$Builder.add(callable);
        }
        return immutableList$Builder.build();
    }

    public final boolean awaitTermination(long l10, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(l10, timeUnit);
    }

    public final void execute(Runnable runnable) {
        ExecutorService executorService = this.delegate;
        runnable = this.wrapTask(runnable);
        executorService.execute(runnable);
    }

    public final List invokeAll(Collection collection) {
        ExecutorService executorService = this.delegate;
        collection = this.wrapTasks(collection);
        return executorService.invokeAll(collection);
    }

    public final List invokeAll(Collection collection, long l10, TimeUnit timeUnit) {
        ExecutorService executorService = this.delegate;
        collection = this.wrapTasks(collection);
        return executorService.invokeAll(collection, l10, timeUnit);
    }

    public final Object invokeAny(Collection collection) {
        ExecutorService executorService = this.delegate;
        collection = this.wrapTasks(collection);
        return executorService.invokeAny(collection);
    }

    public final Object invokeAny(Collection collection, long l10, TimeUnit timeUnit) {
        ExecutorService executorService = this.delegate;
        collection = this.wrapTasks(collection);
        return executorService.invokeAny(collection, l10, timeUnit);
    }

    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public final void shutdown() {
        this.delegate.shutdown();
    }

    public final List shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public final Future submit(Runnable runnable) {
        ExecutorService executorService = this.delegate;
        runnable = this.wrapTask(runnable);
        return executorService.submit(runnable);
    }

    public final Future submit(Runnable runnable, Object object) {
        ExecutorService executorService = this.delegate;
        runnable = this.wrapTask(runnable);
        return executorService.submit(runnable, object);
    }

    public final Future submit(Callable callable) {
        ExecutorService executorService = this.delegate;
        callable = (Callable)Preconditions.checkNotNull(callable);
        callable = this.wrapTask(callable);
        return executorService.submit(callable);
    }

    public Runnable wrapTask(Runnable object) {
        object = Executors.callable((Runnable)object, null);
        object = this.wrapTask((Callable)object);
        WrappingExecutorService$1 wrappingExecutorService$1 = new WrappingExecutorService$1(this, (Callable)object);
        return wrappingExecutorService$1;
    }

    public abstract Callable wrapTask(Callable var1);
}

