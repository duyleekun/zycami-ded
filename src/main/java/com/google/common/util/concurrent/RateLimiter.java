/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothBursty;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothWarmingUp;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class RateLimiter {
    private volatile Object mutexDoNotUseDirectly;
    private final RateLimiter$SleepingStopwatch stopwatch;

    public RateLimiter(RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        this.stopwatch = rateLimiter$SleepingStopwatch = (RateLimiter$SleepingStopwatch)Preconditions.checkNotNull(rateLimiter$SleepingStopwatch);
    }

    private boolean canAcquire(long l10, long l11) {
        long l12 = this.queryEarliestAvailable(l10) - l11;
        long l13 = l12 - l10;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private static void checkPermits(int n10) {
        boolean bl2 = n10 > 0;
        Preconditions.checkArgument(bl2, "Requested permits (%s) must be positive", n10);
    }

    public static RateLimiter create(double d10) {
        RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch = RateLimiter$SleepingStopwatch.createFromSystemTimer();
        return RateLimiter.create(d10, rateLimiter$SleepingStopwatch);
    }

    public static RateLimiter create(double d10, long l10, TimeUnit timeUnit) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "warmupPeriod must not be negative: %s", l10);
        RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch = RateLimiter$SleepingStopwatch.createFromSystemTimer();
        return RateLimiter.create(d10, l10, timeUnit, 3.0, rateLimiter$SleepingStopwatch);
    }

    public static RateLimiter create(double d10, long l10, TimeUnit timeUnit, double d11, RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        SmoothRateLimiter$SmoothWarmingUp smoothRateLimiter$SmoothWarmingUp = new SmoothRateLimiter$SmoothWarmingUp(rateLimiter$SleepingStopwatch, l10, timeUnit, d11);
        smoothRateLimiter$SmoothWarmingUp.setRate(d10);
        return smoothRateLimiter$SmoothWarmingUp;
    }

    public static RateLimiter create(double d10, RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch) {
        SmoothRateLimiter$SmoothBursty smoothRateLimiter$SmoothBursty = new SmoothRateLimiter$SmoothBursty(rateLimiter$SleepingStopwatch, 1.0);
        smoothRateLimiter$SmoothBursty.setRate(d10);
        return smoothRateLimiter$SmoothBursty;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object mutex() {
        Object object = this.mutexDoNotUseDirectly;
        if (object != null) return object;
        synchronized (this) {
            object = this.mutexDoNotUseDirectly;
            if (object != null) return object;
            this.mutexDoNotUseDirectly = object = new Object();
            return object;
        }
    }

    public double acquire() {
        return this.acquire(1);
    }

    public double acquire(int n10) {
        long l10 = this.reserve(n10);
        this.stopwatch.sleepMicrosUninterruptibly(l10);
        double d10 = (double)l10 * 1.0;
        double d11 = TimeUnit.SECONDS.toMicros(1L);
        return d10 / d11;
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double var1, long var3);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final double getRate() {
        Object object = this.mutex();
        synchronized (object) {
            return this.doGetRate();
        }
    }

    public abstract long queryEarliestAvailable(long var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long reserve(int n10) {
        RateLimiter.checkPermits(n10);
        Object object = this.mutex();
        synchronized (object) {
            RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch = this.stopwatch;
            long l10 = rateLimiter$SleepingStopwatch.readMicros();
            return this.reserveAndGetWaitLength(n10, l10);
        }
    }

    public final long reserveAndGetWaitLength(int n10, long l10) {
        return Math.max(this.reserveEarliestAvailable(n10, l10) - l10, 0L);
    }

    public abstract long reserveEarliestAvailable(int var1, long var2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setRate(double d10) {
        Object object;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object2 > 0 && (object2 = (Object)Double.isNaN(d10)) == false) {
            object2 = true;
        } else {
            object2 = false;
            object = null;
        }
        Object object3 = "rate must be positive";
        Preconditions.checkArgument((boolean)object2, object3);
        object = this.mutex();
        synchronized (object) {
            object3 = this.stopwatch;
            long l10 = ((RateLimiter$SleepingStopwatch)object3).readMicros();
            this.doSetRate(d10, l10);
            return;
        }
    }

    public String toString() {
        Locale locale = Locale.ROOT;
        Object[] objectArray = new Object[1];
        Double d10 = this.getRate();
        objectArray[0] = d10;
        return String.format(locale, "RateLimiter[stableRate=%3.1fqps]", objectArray);
    }

    public boolean tryAcquire() {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return this.tryAcquire(1, 0L, timeUnit);
    }

    public boolean tryAcquire(int n10) {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return this.tryAcquire(n10, 0L, timeUnit);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean tryAcquire(int n10, long l10, TimeUnit object) {
        long l11;
        l10 = object.toMicros(l10);
        long l12 = 0L;
        l10 = Math.max(l10, l12);
        RateLimiter.checkPermits(n10);
        object = this.mutex();
        synchronized (object) {
            RateLimiter$SleepingStopwatch rateLimiter$SleepingStopwatch = this.stopwatch;
            l12 = rateLimiter$SleepingStopwatch.readMicros();
            boolean bl2 = this.canAcquire(l12, l10);
            if (!bl2) {
                return false;
            }
            l11 = this.reserveAndGetWaitLength(n10, l12);
        }
        this.stopwatch.sleepMicrosUninterruptibly(l11);
        return true;
    }

    public boolean tryAcquire(long l10, TimeUnit timeUnit) {
        return this.tryAcquire(1, l10, timeUnit);
    }
}

