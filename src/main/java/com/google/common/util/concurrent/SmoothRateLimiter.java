/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter$1;
import java.util.concurrent.TimeUnit;

public abstract class SmoothRateLimiter
extends RateLimiter {
    public double maxPermits;
    private long nextFreeTicketMicros = 0L;
    public double stableIntervalMicros;
    public double storedPermits;

    private SmoothRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        super(rateLimiter$SleepingStopwatch);
    }

    public /* synthetic */ SmoothRateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch, SmoothRateLimiter$1 smoothRateLimiter$1) {
        this(rateLimiter$SleepingStopwatch);
    }

    public abstract double coolDownIntervalMicros();

    public final double doGetRate() {
        double d10 = TimeUnit.SECONDS.toMicros(1L);
        double d11 = this.stableIntervalMicros;
        return d10 / d11;
    }

    public abstract void doSetRate(double var1, double var3);

    public final void doSetRate(double d10, long l10) {
        double d11;
        this.resync(l10);
        this.stableIntervalMicros = d11 = (double)TimeUnit.SECONDS.toMicros(1L) / d10;
        this.doSetRate(d10, d11);
    }

    public final long queryEarliestAvailable(long l10) {
        return this.nextFreeTicketMicros;
    }

    public final long reserveEarliestAvailable(int n10, long l10) {
        this.resync(l10);
        l10 = this.nextFreeTicketMicros;
        double d10 = n10;
        double d11 = this.storedPermits;
        d11 = Math.min(d10, d11);
        double d12 = this.storedPermits;
        long l11 = this.storedPermitsToWaitTime(d12, d11);
        double d13 = this.stableIntervalMicros;
        long l12 = (long)((d10 -= d11) * d13);
        l11 += l12;
        this.nextFreeTicketMicros = l12 = LongMath.saturatedAdd(this.nextFreeTicketMicros, l11);
        this.storedPermits = d10 = this.storedPermits - d11;
        return l10;
    }

    public void resync(long l10) {
        long l11 = this.nextFreeTicketMicros;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l11 = l10 - l11;
            double d10 = l11;
            double d11 = this.coolDownIntervalMicros();
            d10 /= d11;
            d11 = this.maxPermits;
            double d12 = this.storedPermits + d10;
            this.storedPermits = d10 = Math.min(d11, d12);
            this.nextFreeTicketMicros = l10;
        }
    }

    public abstract long storedPermitsToWaitTime(double var1, double var3);
}

