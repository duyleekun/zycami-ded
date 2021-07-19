/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class CycleDetectingLockFactory$CycleDetectingReentrantLock
extends ReentrantLock
implements CycleDetectingLockFactory$CycleDetectingLock {
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    public final /* synthetic */ CycleDetectingLockFactory this$0;

    private CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory object, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2) {
        this.this$0 = object;
        super(bl2);
        this.lockGraphNode = object = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(cycleDetectingLockFactory$LockGraphNode);
    }

    public /* synthetic */ CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory, cycleDetectingLockFactory$LockGraphNode, bl2);
    }

    public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
        return this.lockGraphNode;
    }

    public boolean isAcquiredByCurrentThread() {
        return this.isHeldByCurrentThread();
    }

    public void lock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, this);
        try {
            super.lock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this);
        }
    }

    public void lockInterruptibly() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, this);
        try {
            super.lockInterruptibly();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this);
        }
    }

    public boolean tryLock() {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, this);
        try {
            boolean bl2 = super.tryLock();
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this);
        }
    }

    public boolean tryLock(long l10, TimeUnit timeUnit) {
        CycleDetectingLockFactory cycleDetectingLockFactory = this.this$0;
        CycleDetectingLockFactory.access$600(cycleDetectingLockFactory, this);
        try {
            boolean bl2 = super.tryLock(l10, timeUnit);
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this);
        }
    }

    public void unlock() {
        try {
            super.unlock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this);
        }
    }
}

