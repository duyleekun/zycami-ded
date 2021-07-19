/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class CycleDetectingLockFactory$WithExplicitOrdering
extends CycleDetectingLockFactory {
    private final Map lockGraphNodes;

    public CycleDetectingLockFactory$WithExplicitOrdering(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, Map map) {
        super(cycleDetectingLockFactory$Policy, null);
        this.lockGraphNodes = map;
    }

    public ReentrantLock newReentrantLock(Enum enum_) {
        return this.newReentrantLock(enum_, false);
    }

    public ReentrantLock newReentrantLock(Enum object, boolean bl2) {
        Object object2 = this.policy;
        CycleDetectingLockFactory$Policies cycleDetectingLockFactory$Policies = CycleDetectingLockFactory$Policies.DISABLED;
        if (object2 == cycleDetectingLockFactory$Policies) {
            object = new ReentrantLock(bl2);
        } else {
            object = (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(object);
            cycleDetectingLockFactory$Policies = null;
            object = object2 = new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, (CycleDetectingLockFactory$LockGraphNode)object, bl2, null);
        }
        return object;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(Enum enum_) {
        return this.newReentrantReadWriteLock(enum_, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(Enum object, boolean bl2) {
        Object object2 = this.policy;
        CycleDetectingLockFactory$Policies cycleDetectingLockFactory$Policies = CycleDetectingLockFactory$Policies.DISABLED;
        if (object2 == cycleDetectingLockFactory$Policies) {
            object = new ReentrantReadWriteLock(bl2);
        } else {
            object = (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(object);
            cycleDetectingLockFactory$Policies = null;
            object = object2 = new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory$LockGraphNode)object, bl2, null);
        }
        return object;
    }
}

