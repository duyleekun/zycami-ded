/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock
extends ReentrantReadWriteLock
implements CycleDetectingLockFactory$CycleDetectingLock {
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    private final CycleDetectingLockFactory$CycleDetectingReentrantReadLock readLock;
    public final /* synthetic */ CycleDetectingLockFactory this$0;
    private final CycleDetectingLockFactory$CycleDetectingReentrantWriteLock writeLock;

    private CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory object, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2) {
        Lock lock;
        this.this$0 = object;
        super(bl2);
        this.readLock = lock = new CycleDetectingLockFactory$CycleDetectingReentrantReadLock((CycleDetectingLockFactory)object, this);
        super((CycleDetectingLockFactory)object, this);
        this.writeLock = lock;
        this.lockGraphNode = object = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(cycleDetectingLockFactory$LockGraphNode);
    }

    public /* synthetic */ CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory, cycleDetectingLockFactory$LockGraphNode, bl2);
    }

    public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
        return this.lockGraphNode;
    }

    public boolean isAcquiredByCurrentThread() {
        int n10 = this.isWriteLockedByCurrentThread();
        n10 = n10 == 0 && (n10 = this.getReadHoldCount()) <= 0 ? 0 : 1;
        return n10 != 0;
    }

    public ReentrantReadWriteLock.ReadLock readLock() {
        return this.readLock;
    }

    public ReentrantReadWriteLock.WriteLock writeLock() {
        return this.writeLock;
    }
}

