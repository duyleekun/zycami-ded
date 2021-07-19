/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;

public final class RateLimiter$SleepingStopwatch$1
extends RateLimiter$SleepingStopwatch {
    public final Stopwatch stopwatch;

    public RateLimiter$SleepingStopwatch$1() {
        Stopwatch stopwatch;
        this.stopwatch = stopwatch = Stopwatch.createStarted();
    }

    public long readMicros() {
        Stopwatch stopwatch = this.stopwatch;
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return stopwatch.elapsed(timeUnit);
    }

    public void sleepMicrosUninterruptibly(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            TimeUnit timeUnit = TimeUnit.MICROSECONDS;
            Uninterruptibles.sleepUninterruptibly(l10, timeUnit);
        }
    }
}

