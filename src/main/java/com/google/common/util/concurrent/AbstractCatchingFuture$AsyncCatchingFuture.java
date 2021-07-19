/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractCatchingFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class AbstractCatchingFuture$AsyncCatchingFuture
extends AbstractCatchingFuture {
    public AbstractCatchingFuture$AsyncCatchingFuture(ListenableFuture listenableFuture, Class clazz, AsyncFunction asyncFunction) {
        super(listenableFuture, clazz, asyncFunction);
    }

    public ListenableFuture doFallback(AsyncFunction asyncFunction, Throwable object) {
        object = asyncFunction.apply(object);
        Preconditions.checkNotNull(object, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object)asyncFunction);
        return object;
    }

    public void setResult(ListenableFuture listenableFuture) {
        this.setFuture(listenableFuture);
    }
}

