/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$Failure$1;

public final class AbstractResolvableFuture$Failure {
    public static final AbstractResolvableFuture$Failure FALLBACK_INSTANCE;
    public final Throwable exception;

    static {
        AbstractResolvableFuture$Failure abstractResolvableFuture$Failure;
        AbstractResolvableFuture$Failure$1 abstractResolvableFuture$Failure$1 = new AbstractResolvableFuture$Failure$1("Failure occurred while trying to finish a future.");
        FALLBACK_INSTANCE = abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure(abstractResolvableFuture$Failure$1);
    }

    public AbstractResolvableFuture$Failure(Throwable throwable) {
        this.exception = throwable = (Throwable)AbstractResolvableFuture.checkNotNull(throwable);
    }
}

