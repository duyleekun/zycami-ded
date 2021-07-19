/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import java.util.concurrent.locks.LockSupport;

public final class AbstractFuture$Waiter {
    public static final AbstractFuture$Waiter TOMBSTONE;
    public volatile AbstractFuture$Waiter next;
    public volatile Thread thread;

    static {
        AbstractFuture$Waiter abstractFuture$Waiter;
        TOMBSTONE = abstractFuture$Waiter = new AbstractFuture$Waiter(false);
    }

    public AbstractFuture$Waiter() {
        AbstractFuture$AtomicHelper abstractFuture$AtomicHelper = AbstractFuture.access$200();
        Thread thread = Thread.currentThread();
        abstractFuture$AtomicHelper.putThread(this, thread);
    }

    public AbstractFuture$Waiter(boolean bl2) {
    }

    public void setNext(AbstractFuture$Waiter abstractFuture$Waiter) {
        AbstractFuture.access$200().putNext(this, abstractFuture$Waiter);
    }

    public void unpark() {
        Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }
}

