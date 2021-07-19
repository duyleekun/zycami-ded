/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper;
import java.util.concurrent.locks.LockSupport;

public final class AbstractResolvableFuture$Waiter {
    public static final AbstractResolvableFuture$Waiter TOMBSTONE;
    public volatile AbstractResolvableFuture$Waiter next;
    public volatile Thread thread;

    static {
        AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter;
        TOMBSTONE = abstractResolvableFuture$Waiter = new AbstractResolvableFuture$Waiter(false);
    }

    public AbstractResolvableFuture$Waiter() {
        AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper = AbstractResolvableFuture.ATOMIC_HELPER;
        Thread thread = Thread.currentThread();
        abstractResolvableFuture$AtomicHelper.putThread(this, thread);
    }

    public AbstractResolvableFuture$Waiter(boolean bl2) {
    }

    public void setNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter) {
        AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, abstractResolvableFuture$Waiter);
    }

    public void unpark() {
        Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }
}

