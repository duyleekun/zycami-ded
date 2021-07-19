/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingLock;
import com.google.common.util.concurrent.Striped$WeakSafeCondition;
import com.google.common.util.concurrent.Striped$WeakSafeReadWriteLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class Striped$WeakSafeLock
extends ForwardingLock {
    private final Lock delegate;
    private final Striped$WeakSafeReadWriteLock strongReference;

    public Striped$WeakSafeLock(Lock lock, Striped$WeakSafeReadWriteLock striped$WeakSafeReadWriteLock) {
        this.delegate = lock;
        this.strongReference = striped$WeakSafeReadWriteLock;
    }

    public Lock delegate() {
        return this.delegate;
    }

    public Condition newCondition() {
        Condition condition = this.delegate.newCondition();
        Striped$WeakSafeReadWriteLock striped$WeakSafeReadWriteLock = this.strongReference;
        Striped$WeakSafeCondition striped$WeakSafeCondition = new Striped$WeakSafeCondition(condition, striped$WeakSafeReadWriteLock);
        return striped$WeakSafeCondition;
    }
}

