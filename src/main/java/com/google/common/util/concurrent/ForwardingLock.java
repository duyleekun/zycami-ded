/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public abstract class ForwardingLock
implements Lock {
    public abstract Lock delegate();

    public void lock() {
        this.delegate().lock();
    }

    public void lockInterruptibly() {
        this.delegate().lockInterruptibly();
    }

    public Condition newCondition() {
        return this.delegate().newCondition();
    }

    public boolean tryLock() {
        return this.delegate().tryLock();
    }

    public boolean tryLock(long l10, TimeUnit timeUnit) {
        return this.delegate().tryLock(l10, timeUnit);
    }

    public void unlock() {
        this.delegate().unlock();
    }
}

