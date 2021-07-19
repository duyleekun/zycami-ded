/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper;
import androidx.concurrent.futures.AbstractResolvableFuture$Listener;
import androidx.concurrent.futures.AbstractResolvableFuture$Waiter;

public final class AbstractResolvableFuture$SynchronizedHelper
extends AbstractResolvableFuture$AtomicHelper {
    public AbstractResolvableFuture$SynchronizedHelper() {
        super(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2) {
        synchronized (abstractResolvableFuture) {
            AbstractResolvableFuture$Listener abstractResolvableFuture$Listener3 = abstractResolvableFuture.listeners;
            if (abstractResolvableFuture$Listener3 != abstractResolvableFuture$Listener) return false;
            abstractResolvableFuture.listeners = abstractResolvableFuture$Listener2;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object object, Object object2) {
        synchronized (abstractResolvableFuture) {
            Object object3 = abstractResolvableFuture.value;
            if (object3 != object) return false;
            abstractResolvableFuture.value = object2;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        synchronized (abstractResolvableFuture) {
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter3 = abstractResolvableFuture.waiters;
            if (abstractResolvableFuture$Waiter3 != abstractResolvableFuture$Waiter) return false;
            abstractResolvableFuture.waiters = abstractResolvableFuture$Waiter2;
            return true;
        }
    }

    public void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        abstractResolvableFuture$Waiter.next = abstractResolvableFuture$Waiter2;
    }

    public void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread) {
        abstractResolvableFuture$Waiter.thread = thread;
    }
}

