/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;

public final class TrustedListenableFutureTask$TrustedFutureInterruptibleTask
extends InterruptibleTask {
    private final Callable callable;
    public final /* synthetic */ TrustedListenableFutureTask this$0;

    public TrustedListenableFutureTask$TrustedFutureInterruptibleTask(TrustedListenableFutureTask object, Callable callable) {
        this.this$0 = object;
        this.callable = object = (Callable)Preconditions.checkNotNull(callable);
    }

    public void afterRanInterruptibly(Object object, Throwable object2) {
        if (object2 == null) {
            object2 = this.this$0;
            ((AbstractFuture)object2).set(object);
        } else {
            object = this.this$0;
            ((AbstractFuture)object).setException((Throwable)object2);
        }
    }

    public final boolean isDone() {
        return this.this$0.isDone();
    }

    public Object runInterruptibly() {
        return this.callable.call();
    }

    public String toPendingString() {
        return this.callable.toString();
    }
}

