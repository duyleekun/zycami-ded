/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CycleDetectingLockFactory$CycleDetectingReentrantReadLock
extends ReentrantReadWriteLock.ReadLock {
    public final CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock readWriteLock;
    public final /* synthetic */ CycleDetectingLockFactory this$0;

    public CycleDetectingLockFactory$CycleDetectingReentrantReadLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock) {
        this.this$0 = cycleDetectingLockFactory;
        super(cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        this.readWriteLock = cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
    }

    public void lock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock = this.readWriteLock;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        try {
            super.lock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.readWriteLock);
        }
    }

    public void lockInterruptibly() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock = this.readWriteLock;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        try {
            super.lockInterruptibly();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.readWriteLock);
        }
    }

    public boolean tryLock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock = this.readWriteLock;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        try {
            boolean bl2 = super.tryLock();
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.readWriteLock);
        }
    }

    public boolean tryLock(long l10, TimeUnit timeUnit) {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock = this.readWriteLock;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        try {
            boolean bl2 = super.tryLock(l10, timeUnit);
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.readWriteLock);
        }
    }

    public void unlock() {
        try {
            super.unlock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.readWriteLock);
        }
    }
}

