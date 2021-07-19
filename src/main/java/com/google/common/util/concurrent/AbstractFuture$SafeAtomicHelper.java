/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class AbstractFuture$SafeAtomicHelper
extends AbstractFuture$AtomicHelper {
    public final AtomicReferenceFieldUpdater listenersUpdater;
    public final AtomicReferenceFieldUpdater valueUpdater;
    public final AtomicReferenceFieldUpdater waiterNextUpdater;
    public final AtomicReferenceFieldUpdater waiterThreadUpdater;
    public final AtomicReferenceFieldUpdater waitersUpdater;

    public AbstractFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.waiterThreadUpdater = atomicReferenceFieldUpdater;
        this.waiterNextUpdater = atomicReferenceFieldUpdater2;
        this.waitersUpdater = atomicReferenceFieldUpdater3;
        this.listenersUpdater = atomicReferenceFieldUpdater4;
        this.valueUpdater = atomicReferenceFieldUpdater5;
    }

    public boolean casListeners(AbstractFuture abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        return this.listenersUpdater.compareAndSet(abstractFuture, abstractFuture$Listener, abstractFuture$Listener2);
    }

    public boolean casValue(AbstractFuture abstractFuture, Object object, Object object2) {
        return this.valueUpdater.compareAndSet(abstractFuture, object, object2);
    }

    public boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        return this.waitersUpdater.compareAndSet(abstractFuture, abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    public void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        this.waiterNextUpdater.lazySet(abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    public void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        this.waiterThreadUpdater.lazySet(abstractFuture$Waiter, thread);
    }
}

