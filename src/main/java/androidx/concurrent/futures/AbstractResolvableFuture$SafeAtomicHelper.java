/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper;
import androidx.concurrent.futures.AbstractResolvableFuture$Listener;
import androidx.concurrent.futures.AbstractResolvableFuture$Waiter;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class AbstractResolvableFuture$SafeAtomicHelper
extends AbstractResolvableFuture$AtomicHelper {
    public final AtomicReferenceFieldUpdater listenersUpdater;
    public final AtomicReferenceFieldUpdater valueUpdater;
    public final AtomicReferenceFieldUpdater waiterNextUpdater;
    public final AtomicReferenceFieldUpdater waiterThreadUpdater;
    public final AtomicReferenceFieldUpdater waitersUpdater;

    public AbstractResolvableFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    public boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener, AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2) {
        return this.listenersUpdater.compareAndSet(abstractResolvableFuture, abstractResolvableFuture$Listener, abstractResolvableFuture$Listener2);
    }

    public boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object object, Object object2) {
        return this.valueUpdater.compareAndSet(abstractResolvableFuture, object, object2);
    }

    public boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        return this.waitersUpdater.compareAndSet(abstractResolvableFuture, abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2);
    }

    public void putNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2) {
        this.waiterNextUpdater.lazySet(abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2);
    }

    public void putThread(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(abstractResolvableFuture$Waiter, thread);
    }
}

