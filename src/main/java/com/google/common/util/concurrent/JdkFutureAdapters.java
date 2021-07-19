/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class JdkFutureAdapters {
    private JdkFutureAdapters() {
    }

    public static ListenableFuture listenInPoolThread(Future future) {
        boolean bl2 = future instanceof ListenableFuture;
        if (bl2) {
            return (ListenableFuture)future;
        }
        JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter = new JdkFutureAdapters$ListenableFutureAdapter(future);
        return jdkFutureAdapters$ListenableFutureAdapter;
    }

    public static ListenableFuture listenInPoolThread(Future future, Executor executor) {
        Preconditions.checkNotNull(executor);
        boolean bl2 = future instanceof ListenableFuture;
        if (bl2) {
            return (ListenableFuture)future;
        }
        JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter = new JdkFutureAdapters$ListenableFutureAdapter(future, executor);
        return jdkFutureAdapters$ListenableFutureAdapter;
    }
}

