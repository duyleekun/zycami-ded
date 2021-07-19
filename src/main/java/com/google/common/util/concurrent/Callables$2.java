/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

public final class Callables$2
implements AsyncCallable {
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ ListeningExecutorService val$listeningExecutorService;

    public Callables$2(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.val$listeningExecutorService = listeningExecutorService;
        this.val$callable = callable;
    }

    public ListenableFuture call() {
        ListeningExecutorService listeningExecutorService = this.val$listeningExecutorService;
        Callable callable = this.val$callable;
        return listeningExecutorService.submit(callable);
    }
}

