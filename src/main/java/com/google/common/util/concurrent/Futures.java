/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.util.concurrent.AbstractCatchingFuture;
import com.google.common.util.concurrent.AbstractTransformFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.CollectionFuture$ListFuture;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.FluentFuture$TrustedFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$2;
import com.google.common.util.concurrent.Futures$3;
import com.google.common.util.concurrent.Futures$CallbackListener;
import com.google.common.util.concurrent.Futures$FutureCombiner;
import com.google.common.util.concurrent.Futures$InCompletionOrderFuture;
import com.google.common.util.concurrent.Futures$InCompletionOrderState;
import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture;
import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.GwtFuturesCatchingSpecialization;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ImmediateFuture$ImmediateCancelledFuture;
import com.google.common.util.concurrent.ImmediateFuture$ImmediateFailedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.TimeoutFuture;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class Futures
extends GwtFuturesCatchingSpecialization {
    private Futures() {
    }

    public static void addCallback(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        Futures$CallbackListener futures$CallbackListener = new Futures$CallbackListener(listenableFuture, futureCallback);
        listenableFuture.addListener(futures$CallbackListener, executor);
    }

    public static ListenableFuture allAsList(Iterable iterable) {
        iterable = ImmutableList.copyOf(iterable);
        CollectionFuture$ListFuture collectionFuture$ListFuture = new CollectionFuture$ListFuture((ImmutableCollection)iterable, true);
        return collectionFuture$ListFuture;
    }

    public static ListenableFuture allAsList(ListenableFuture ... object) {
        object = ImmutableList.copyOf(object);
        CollectionFuture$ListFuture collectionFuture$ListFuture = new CollectionFuture$ListFuture((ImmutableCollection)object, true);
        return collectionFuture$ListFuture;
    }

    public static ListenableFuture catching(ListenableFuture listenableFuture, Class clazz, Function function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, clazz, function, executor);
    }

    public static ListenableFuture catchingAsync(ListenableFuture listenableFuture, Class clazz, AsyncFunction asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, clazz, asyncFunction, executor);
    }

    public static Object getChecked(Future future, Class clazz) {
        return FuturesGetChecked.getChecked(future, clazz);
    }

    public static Object getChecked(Future future, Class clazz, long l10, TimeUnit timeUnit) {
        return FuturesGetChecked.getChecked(future, clazz, l10, timeUnit);
    }

    public static Object getDone(Future future) {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", (Object)future);
        return Uninterruptibles.getUninterruptibly(future);
    }

    public static Object getUnchecked(Future object) {
        Preconditions.checkNotNull(object);
        try {
            return Uninterruptibles.getUninterruptibly((Future)object);
        }
        catch (ExecutionException executionException) {
            Futures.wrapAndThrowUnchecked(executionException.getCause());
            object = new AssertionError();
            throw object;
        }
    }

    public static ListenableFuture immediateCancelledFuture() {
        ImmediateFuture$ImmediateCancelledFuture immediateFuture$ImmediateCancelledFuture = new ImmediateFuture$ImmediateCancelledFuture();
        return immediateFuture$ImmediateCancelledFuture;
    }

    public static ListenableFuture immediateFailedFuture(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        ImmediateFuture$ImmediateFailedFuture immediateFuture$ImmediateFailedFuture = new ImmediateFuture$ImmediateFailedFuture(throwable);
        return immediateFuture$ImmediateFailedFuture;
    }

    public static ListenableFuture immediateFuture(Object object) {
        if (object == null) {
            return ImmediateFuture.NULL;
        }
        ImmediateFuture immediateFuture = new ImmediateFuture(object);
        return immediateFuture;
    }

    public static ImmutableList inCompletionOrder(Iterable object) {
        int n10;
        Object object2;
        int n11;
        int n12 = object instanceof Collection;
        object = n12 != 0 ? (Collection)object : ImmutableList.copyOf((Iterable)object);
        n12 = object.size();
        Object object3 = new ListenableFuture[n12];
        object = object.toArray((T[])object3);
        ImmutableCollection immutableCollection = null;
        object3 = new Futures$InCompletionOrderState((ListenableFuture[])object, null);
        Object object4 = ImmutableList.builder();
        int n13 = 0;
        Futures$3 futures$3 = null;
        for (int i10 = 0; i10 < (n11 = ((ListenableFuture[])object).length); ++i10) {
            object2 = new Futures$InCompletionOrderFuture((Futures$InCompletionOrderState)object3, null);
            ((ImmutableList$Builder)object4).add(object2);
        }
        immutableCollection = ((ImmutableList$Builder)object4).build();
        while (n13 < (n10 = ((ListenableFuture[])object).length)) {
            object4 = object[n13];
            futures$3 = new Futures$3((Futures$InCompletionOrderState)object3, (ImmutableList)immutableCollection, n13);
            object2 = MoreExecutors.directExecutor();
            object4.addListener(futures$3, (Executor)object2);
            ++n13;
        }
        return immutableCollection;
    }

    public static Future lazyTransform(Future future, Function function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        Futures$2 futures$2 = new Futures$2(future, function);
        return futures$2;
    }

    public static ListenableFuture nonCancellationPropagating(ListenableFuture listenableFuture) {
        boolean bl2 = listenableFuture.isDone();
        if (bl2) {
            return listenableFuture;
        }
        Futures$NonCancellationPropagatingFuture futures$NonCancellationPropagatingFuture = new Futures$NonCancellationPropagatingFuture(listenableFuture);
        Executor executor = MoreExecutors.directExecutor();
        listenableFuture.addListener(futures$NonCancellationPropagatingFuture, executor);
        return futures$NonCancellationPropagatingFuture;
    }

    public static ListenableFuture scheduleAsync(AsyncCallable object, long l10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        object = TrustedListenableFutureTask.create((AsyncCallable)object);
        Object object2 = scheduledExecutorService.schedule((Runnable)object, l10, timeUnit);
        Futures$1 futures$1 = new Futures$1((Future)object2);
        object2 = MoreExecutors.directExecutor();
        ((FluentFuture$TrustedFuture)object).addListener(futures$1, (Executor)object2);
        return object;
    }

    public static ListenableFuture submit(Runnable runnable, Executor executor) {
        runnable = TrustedListenableFutureTask.create(runnable, null);
        executor.execute(runnable);
        return runnable;
    }

    public static ListenableFuture submit(Callable object, Executor executor) {
        object = TrustedListenableFutureTask.create((Callable)object);
        executor.execute((Runnable)object);
        return object;
    }

    public static ListenableFuture submitAsync(AsyncCallable object, Executor executor) {
        object = TrustedListenableFutureTask.create((AsyncCallable)object);
        executor.execute((Runnable)object);
        return object;
    }

    public static ListenableFuture successfulAsList(Iterable iterable) {
        iterable = ImmutableList.copyOf(iterable);
        CollectionFuture$ListFuture collectionFuture$ListFuture = new CollectionFuture$ListFuture((ImmutableCollection)iterable, false);
        return collectionFuture$ListFuture;
    }

    public static ListenableFuture successfulAsList(ListenableFuture ... object) {
        object = ImmutableList.copyOf(object);
        CollectionFuture$ListFuture collectionFuture$ListFuture = new CollectionFuture$ListFuture((ImmutableCollection)object, false);
        return collectionFuture$ListFuture;
    }

    public static ListenableFuture transform(ListenableFuture listenableFuture, Function function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    public static ListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    public static Futures$FutureCombiner whenAllComplete(Iterable iterable) {
        iterable = ImmutableList.copyOf(iterable);
        Futures$FutureCombiner futures$FutureCombiner = new Futures$FutureCombiner(false, (ImmutableList)iterable, null);
        return futures$FutureCombiner;
    }

    public static Futures$FutureCombiner whenAllComplete(ListenableFuture ... object) {
        object = ImmutableList.copyOf(object);
        Futures$FutureCombiner futures$FutureCombiner = new Futures$FutureCombiner(false, (ImmutableList)object, null);
        return futures$FutureCombiner;
    }

    public static Futures$FutureCombiner whenAllSucceed(Iterable iterable) {
        iterable = ImmutableList.copyOf(iterable);
        Futures$FutureCombiner futures$FutureCombiner = new Futures$FutureCombiner(true, (ImmutableList)iterable, null);
        return futures$FutureCombiner;
    }

    public static Futures$FutureCombiner whenAllSucceed(ListenableFuture ... object) {
        object = ImmutableList.copyOf(object);
        Futures$FutureCombiner futures$FutureCombiner = new Futures$FutureCombiner(true, (ImmutableList)object, null);
        return futures$FutureCombiner;
    }

    public static ListenableFuture withTimeout(ListenableFuture listenableFuture, long l10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        boolean bl2 = listenableFuture.isDone();
        if (bl2) {
            return listenableFuture;
        }
        return TimeoutFuture.create(listenableFuture, l10, timeUnit, scheduledExecutorService);
    }

    private static void wrapAndThrowUnchecked(Throwable throwable) {
        boolean bl2 = throwable instanceof Error;
        if (bl2) {
            throwable = (Error)throwable;
            ExecutionError executionError = new ExecutionError((Error)throwable);
            throw executionError;
        }
        UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(throwable);
        throw uncheckedExecutionException;
    }
}

