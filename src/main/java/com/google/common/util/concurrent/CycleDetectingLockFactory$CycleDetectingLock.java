/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;

public interface CycleDetectingLockFactory$CycleDetectingLock {
    public CycleDetectingLockFactory.LockGraphNode getLockGraphNode();

    public boolean isAcquiredByCurrentThread();
}

