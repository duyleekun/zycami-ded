/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import java.util.concurrent.TimeUnit;

public final class SmoothRateLimiter$SmoothWarmingUp
extends SmoothRateLimiter {
    private double coldFactor;
    private double slope;
    private double thresholdPermits;
    private final long warmupPeriodMicros;

    public SmoothRateLimiter$SmoothWarmingUp(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, long l10, TimeUnit timeUnit, double d10) {
        super(rateLimiter$SleepingStopwatch, null);
        long l11;
        this.warmupPeriodMicros = l11 = timeUnit.toMicros(l10);
        this.coldFactor = d10;
    }

    private double permitsToTime(double d10) {
        double d11 = this.stableIntervalMicros;
        double d12 = this.slope;
        return d11 + (d10 *= d12);
    }

    public double coolDownIntervalMicros() {
        double d10 = this.warmupPeriodMicros;
        double d11 = this.maxPermits;
        return d10 / d11;
    }

    public void doSetRate(double d10, double d11) {
        double d12;
        d10 = this.maxPermits;
        double d13 = this.coldFactor * d11;
        long l10 = this.warmupPeriodMicros;
        this.thresholdPermits = d12 = (double)l10 * 0.5 / d11;
        double d14 = (double)l10 * 2.0;
        double d15 = d11 + d13;
        this.maxPermits = d14 = d14 / d15 + d12;
        d13 -= d11;
        d11 = d14 - d12;
        this.slope = d13 /= d11;
        d11 = 1.0 / 0.0;
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        d13 = 0.0;
        if (object == false) {
            this.storedPermits = d13;
        } else {
            object = d10 == d13 ? 0 : (d10 > d13 ? 1 : -1);
            if (object != false) {
                d11 = this.storedPermits * d14;
                d14 = d11 / d10;
            }
            this.storedPermits = d14;
        }
    }

    public long storedPermitsToWaitTime(double d10, double d11) {
        long l10;
        double d12 = this.thresholdPermits;
        double d13 = (d10 -= d12) - (d12 = 0.0);
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object > 0) {
            d12 = Math.min(d10, d11);
            double d14 = this.permitsToTime(d10);
            d10 -= d12;
            d10 = this.permitsToTime(d10);
            d14 = (d14 + d10) * d12;
            d10 = 2.0;
            l10 = (long)(d14 /= d10);
            d11 -= d12;
        } else {
            l10 = 0L;
            d10 = 0.0;
        }
        long l11 = (long)(this.stableIntervalMicros * d11);
        return l10 + l11;
    }
}

