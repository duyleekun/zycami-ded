/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;

public interface CycleDetectingLockFactory$Policy {
    public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException var1);
}

