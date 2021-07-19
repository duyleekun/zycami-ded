/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;

public final class SmoothRateLimiter$SmoothBursty
extends SmoothRateLimiter {
    public final double maxBurstSeconds;

    public SmoothRateLimiter$SmoothBursty(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, double d10) {
        super(rateLimiter$SleepingStopwatch, null);
        this.maxBurstSeconds = d10;
    }

    public double coolDownIntervalMicros() {
        return this.stableIntervalMicros;
    }

    public void doSetRate(double d10, double d11) {
        double d12;
        d11 = this.maxPermits;
        this.maxPermits = d12 = this.maxBurstSeconds * d10;
        d10 = 1.0 / 0.0;
        double d13 = d11 - d10;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object == false) {
            this.storedPermits = d12;
        } else {
            d10 = 0.0;
            double d14 = d11 - d10;
            Object object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object2 != false) {
                d10 = this.storedPermits * d12 / d11;
            }
            this.storedPermits = d10;
        }
    }

    public long storedPermitsToWaitTime(double d10, double d11) {
        return 0L;
    }
}

