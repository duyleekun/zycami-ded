/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;

public final class AbstractResolvableFuture$Cancellation {
    public static final AbstractResolvableFuture$Cancellation CAUSELESS_CANCELLED;
    public static final AbstractResolvableFuture$Cancellation CAUSELESS_INTERRUPTED;
    public final Throwable cause;
    public final boolean wasInterrupted;

    static {
        boolean bl2 = AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES;
        if (bl2) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            AbstractResolvableFuture$Cancellation abstractResolvableFuture$Cancellation;
            CAUSELESS_CANCELLED = abstractResolvableFuture$Cancellation = new AbstractResolvableFuture$Cancellation(false, null);
            boolean bl3 = true;
            CAUSELESS_INTERRUPTED = abstractResolvableFuture$Cancellation = new AbstractResolvableFuture$Cancellation(bl3, null);
        }
    }

    public AbstractResolvableFuture$Cancellation(boolean bl2, Throwable throwable) {
        this.wasInterrupted = bl2;
        this.cause = throwable;
    }
}

