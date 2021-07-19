/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Striped$WeakSafeLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class Striped$WeakSafeReadWriteLock
implements ReadWriteLock {
    private final ReadWriteLock delegate;

    public Striped$WeakSafeReadWriteLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.delegate = reentrantReadWriteLock;
    }

    public Lock readLock() {
        Lock lock = this.delegate.readLock();
        Striped$WeakSafeLock striped$WeakSafeLock = new Striped$WeakSafeLock(lock, this);
        return striped$WeakSafeLock;
    }

    public Lock writeLock() {
        Lock lock = this.delegate.writeLock();
        Striped$WeakSafeLock striped$WeakSafeLock = new Striped$WeakSafeLock(lock, this);
        return striped$WeakSafeLock;
    }
}

