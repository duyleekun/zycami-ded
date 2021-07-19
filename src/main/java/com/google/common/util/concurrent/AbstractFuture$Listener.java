/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public final class AbstractFuture$Listener {
    public static final AbstractFuture$Listener TOMBSTONE;
    public final Executor executor;
    public AbstractFuture$Listener next;
    public final Runnable task;

    static {
        AbstractFuture$Listener abstractFuture$Listener;
        TOMBSTONE = abstractFuture$Listener = new AbstractFuture$Listener(null, null);
    }

    public AbstractFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}

