/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.system.Clock;
import java.util.concurrent.TimeUnit;

public final class SystemClock
extends Clock {
    private static final SystemClock INSTANCE;

    static {
        SystemClock systemClock;
        INSTANCE = systemClock = new SystemClock();
    }

    private SystemClock() {
    }

    public static SystemClock getInstance() {
        return INSTANCE;
    }

    public long getCurrentTimeNanos() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l10 = System.currentTimeMillis();
        return timeUnit.toNanos(l10);
    }

    public String toString() {
        return "Default millisecond precision clock";
    }
}

