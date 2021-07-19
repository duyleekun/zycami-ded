/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import java.util.concurrent.Executor;

public final class AbstractResolvableFuture$Listener {
    public static final AbstractResolvableFuture$Listener TOMBSTONE;
    public final Executor executor;
    public AbstractResolvableFuture$Listener next;
    public final Runnable task;

    static {
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener;
        TOMBSTONE = abstractResolvableFuture$Listener = new AbstractResolvableFuture$Listener(null, null);
    }

    public AbstractResolvableFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}

