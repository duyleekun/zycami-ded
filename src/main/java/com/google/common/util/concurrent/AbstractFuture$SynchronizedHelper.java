/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;

public final class AbstractFuture$SynchronizedHelper
extends AbstractFuture$AtomicHelper {
    private AbstractFuture$SynchronizedHelper() {
        super(null);
    }

    public /* synthetic */ AbstractFuture$SynchronizedHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casListeners(AbstractFuture abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        synchronized (abstractFuture) {
            AbstractFuture$Listener abstractFuture$Listener3 = AbstractFuture.access$900(abstractFuture);
            if (abstractFuture$Listener3 != abstractFuture$Listener) return false;
            AbstractFuture.access$902(abstractFuture, abstractFuture$Listener2);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casValue(AbstractFuture abstractFuture, Object object, Object object2) {
        synchronized (abstractFuture) {
            Object object3 = AbstractFuture.access$400(abstractFuture);
            if (object3 != object) return false;
            AbstractFuture.access$402(abstractFuture, object2);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        synchronized (abstractFuture) {
            AbstractFuture$Waiter abstractFuture$Waiter3 = AbstractFuture.access$800(abstractFuture);
            if (abstractFuture$Waiter3 != abstractFuture$Waiter) return false;
            AbstractFuture.access$802(abstractFuture, abstractFuture$Waiter2);
            return true;
        }
    }

    public void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        abstractFuture$Waiter.next = abstractFuture$Waiter2;
    }

    public void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        abstractFuture$Waiter.thread = thread;
    }
}

