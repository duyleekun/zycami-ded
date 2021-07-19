/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ForwardingFluentFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.GwtFluentFutureCatchingSpecialization;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class FluentFuture
extends GwtFluentFutureCatchingSpecialization {
    public static FluentFuture from(FluentFuture fluentFuture) {
        return (FluentFuture)Preconditions.checkNotNull(fluentFuture);
    }

    public static FluentFuture from(ListenableFuture listenableFuture) {
        boolean bl2 = listenableFuture instanceof FluentFuture;
        if (bl2) {
            listenableFuture = (FluentFuture)listenableFuture;
        } else {
            ForwardingFluentFuture forwardingFluentFuture = new ForwardingFluentFuture(listenableFuture);
            listenableFuture = forwardingFluentFuture;
        }
        return listenableFuture;
    }

    public final void addCallback(FutureCallback futureCallback, Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    public final FluentFuture catching(Class clazz, Function function, Executor executor) {
        return (FluentFuture)Futures.catching(this, clazz, function, executor);
    }

    public final FluentFuture catchingAsync(Class clazz, AsyncFunction asyncFunction, Executor executor) {
        return (FluentFuture)Futures.catchingAsync(this, clazz, asyncFunction, executor);
    }

    public final FluentFuture transform(Function function, Executor executor) {
        return (FluentFuture)Futures.transform(this, function, executor);
    }

    public final FluentFuture transformAsync(AsyncFunction asyncFunction, Executor executor) {
        return (FluentFuture)Futures.transformAsync(this, asyncFunction, executor);
    }

    public final FluentFuture withTimeout(long l10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (FluentFuture)Futures.withTimeout(this, l10, timeUnit, scheduledExecutorService);
    }
}

