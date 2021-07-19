/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public abstract class ForwardingCondition
implements Condition {
    public void await() {
        this.delegate().await();
    }

    public boolean await(long l10, TimeUnit timeUnit) {
        return this.delegate().await(l10, timeUnit);
    }

    public long awaitNanos(long l10) {
        return this.delegate().awaitNanos(l10);
    }

    public void awaitUninterruptibly() {
        this.delegate().awaitUninterruptibly();
    }

    public boolean awaitUntil(Date date) {
        return this.delegate().awaitUntil(date);
    }

    public abstract Condition delegate();

    public void signal() {
        this.delegate().signal();
    }

    public void signalAll() {
        this.delegate().signalAll();
    }
}

