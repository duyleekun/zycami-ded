/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CycleDetectingLockFactory$Policies$2
extends CycleDetectingLockFactory$Policies {
    public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException cycleDetectingLockFactory$PotentialDeadlockException) {
        Logger logger = CycleDetectingLockFactory.access$100();
        Level level = Level.SEVERE;
        logger.log(level, "Detected potential deadlock", cycleDetectingLockFactory$PotentialDeadlockException);
    }
}

