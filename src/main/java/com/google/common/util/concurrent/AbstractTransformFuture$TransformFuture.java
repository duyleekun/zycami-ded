/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractTransformFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class AbstractTransformFuture$TransformFuture
extends AbstractTransformFuture {
    public AbstractTransformFuture$TransformFuture(ListenableFuture listenableFuture, Function function) {
        super(listenableFuture, function);
    }

    public Object doTransform(Function function, Object object) {
        return function.apply(object);
    }

    public void setResult(Object object) {
        this.set(object);
    }
}

