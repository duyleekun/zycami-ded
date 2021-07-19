/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture$Trusted;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class FluentFuture$TrustedFuture
extends FluentFuture
implements AbstractFuture$Trusted {
    public final void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }

    public final boolean cancel(boolean bl2) {
        return super.cancel(bl2);
    }

    public final Object get() {
        return super.get();
    }

    public final Object get(long l10, TimeUnit timeUnit) {
        return super.get(l10, timeUnit);
    }

    public final boolean isCancelled() {
        return super.isCancelled();
    }

    public final boolean isDone() {
        return super.isDone();
    }
}

