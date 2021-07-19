/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;

public final class CycleDetectingLockFactory$PotentialDeadlockException
extends CycleDetectingLockFactory$ExampleStackTrace {
    private final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace;

    private CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2, CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace) {
        super(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$LockGraphNode2);
        this.conflictingStackTrace = cycleDetectingLockFactory$ExampleStackTrace;
        this.initCause(cycleDetectingLockFactory$ExampleStackTrace);
    }

    public /* synthetic */ CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2, CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$LockGraphNode2, cycleDetectingLockFactory$ExampleStackTrace);
    }

    public CycleDetectingLockFactory$ExampleStackTrace getConflictingStackTrace() {
        return this.conflictingStackTrace;
    }

    public String getMessage() {
        Object object = super.getMessage();
        StringBuilder stringBuilder = new StringBuilder((String)object);
        for (object = this.conflictingStackTrace; object != null; object = ((Throwable)object).getCause()) {
            stringBuilder.append(", ");
            String string2 = ((Throwable)object).getMessage();
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

