/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch$1;

public abstract class RateLimiter$SleepingStopwatch {
    public static RateLimiter$SleepingStopwatch createFromSystemTimer() {
        RateLimiter$SleepingStopwatch$1 rateLimiter$SleepingStopwatch$1 = new RateLimiter$SleepingStopwatch$1();
        return rateLimiter$SleepingStopwatch$1;
    }

    public abstract long readMicros();

    public abstract void sleepMicrosUninterruptibly(long var1);
}

