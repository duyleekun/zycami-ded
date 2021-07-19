/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractTransformFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class AbstractTransformFuture$AsyncTransformFuture
extends AbstractTransformFuture {
    public AbstractTransformFuture$AsyncTransformFuture(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
        super(listenableFuture, asyncFunction);
    }

    public ListenableFuture doTransform(AsyncFunction asyncFunction, Object object) {
        object = asyncFunction.apply(object);
        Preconditions.checkNotNull(object, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object)asyncFunction);
        return object;
    }

    public void setResult(ListenableFuture listenableFuture) {
        this.setFuture(listenableFuture);
    }
}

