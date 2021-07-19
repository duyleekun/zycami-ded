/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$FutureCombiner$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class Futures$FutureCombiner {
    private final boolean allMustSucceed;
    private final ImmutableList futures;

    private Futures$FutureCombiner(boolean bl2, ImmutableList immutableList) {
        this.allMustSucceed = bl2;
        this.futures = immutableList;
    }

    public /* synthetic */ Futures$FutureCombiner(boolean bl2, ImmutableList immutableList, Futures$1 futures$1) {
        this(bl2, immutableList);
    }

    public ListenableFuture call(Callable callable, Executor executor) {
        ImmutableList immutableList = this.futures;
        boolean bl2 = this.allMustSucceed;
        CombinedFuture combinedFuture = new CombinedFuture((ImmutableCollection)immutableList, bl2, executor, callable);
        return combinedFuture;
    }

    public ListenableFuture callAsync(AsyncCallable asyncCallable, Executor executor) {
        ImmutableList immutableList = this.futures;
        boolean bl2 = this.allMustSucceed;
        CombinedFuture combinedFuture = new CombinedFuture((ImmutableCollection)immutableList, bl2, executor, asyncCallable);
        return combinedFuture;
    }

    public ListenableFuture run(Runnable runnable, Executor executor) {
        Futures$FutureCombiner$1 futures$FutureCombiner$1 = new Futures$FutureCombiner$1(this, runnable);
        return this.call(futures$FutureCombiner$1, executor);
    }
}

