/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfMetric;
import java.util.concurrent.TimeUnit;

public class RateLimiter$RateLimiterImpl {
    private static final long MICROS_IN_A_SECOND;
    private static final AndroidLogger logger;
    private final boolean isLogcatEnabled;
    private long mBackgroundCapacity;
    private double mBackgroundRate;
    private long mCapacity;
    private final Clock mClock;
    private long mForegroundCapacity;
    private double mForegroundRate;
    private Timer mLastTimeTokenConsumed;
    private double mRate;
    private long mTokenCount;

    static {
        logger = AndroidLogger.getInstance();
        MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1L);
    }

    public RateLimiter$RateLimiterImpl(double d10, long l10, Clock clock, ConfigResolver configResolver, String string2, boolean bl2) {
        Timer timer;
        this.mClock = clock;
        this.mCapacity = l10;
        this.mRate = d10;
        this.mTokenCount = l10;
        this.mLastTimeTokenConsumed = timer = clock.getTime();
        this.setRateByReadingRemoteConfigValues(configResolver, string2, bl2);
        this.isLogcatEnabled = bl2;
    }

    private static long getBlimitEvents(ConfigResolver configResolver, String string2) {
        String string3 = "Trace";
        if (string2 == string3) {
            return configResolver.getTraceEventCountBackground();
        }
        return configResolver.getNetworkEventCountBackground();
    }

    private static long getBlimitSec(ConfigResolver configResolver, String string2) {
        String string3 = "Trace";
        if (string2 == string3) {
            return configResolver.getRateLimitSec();
        }
        return configResolver.getRateLimitSec();
    }

    private static long getFlimitEvents(ConfigResolver configResolver, String string2) {
        String string3 = "Trace";
        if (string2 == string3) {
            return configResolver.getTraceEventCountForeground();
        }
        return configResolver.getNetworkEventCountForeground();
    }

    private static long getFlimitSec(ConfigResolver configResolver, String string2) {
        String string3 = "Trace";
        if (string2 == string3) {
            return configResolver.getRateLimitSec();
        }
        return configResolver.getRateLimitSec();
    }

    private void setRateByReadingRemoteConfigValues(ConfigResolver object, String object2, boolean bl2) {
        long l10;
        long l11 = RateLimiter$RateLimiterImpl.getFlimitSec((ConfigResolver)object, (String)object2);
        long l12 = RateLimiter$RateLimiterImpl.getFlimitEvents((ConfigResolver)object, (String)object2);
        double d10 = l12;
        double d11 = l11;
        this.mForegroundRate = d10 /= d11;
        this.mForegroundCapacity = l12;
        int n10 = 2;
        int n11 = 1;
        int n12 = 3;
        if (bl2) {
            Object object3;
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object2;
            objectArray[n11] = object3 = Double.valueOf(d10);
            l10 = this.mForegroundCapacity;
            objectArray[n10] = object3 = Long.valueOf(l10);
            object3 = "Foreground %s logging rate:%f, burst capacity:%d";
            androidLogger.debug((String)object3, objectArray);
        }
        l10 = RateLimiter$RateLimiterImpl.getBlimitSec((ConfigResolver)object, (String)object2);
        long l13 = RateLimiter$RateLimiterImpl.getBlimitEvents((ConfigResolver)object, (String)object2);
        double d12 = l13;
        d10 = l10;
        this.mBackgroundRate = d12 /= d10;
        this.mBackgroundCapacity = l13;
        if (bl2) {
            object = logger;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object2;
            objectArray[n11] = object2 = Double.valueOf(d12);
            long l14 = this.mBackgroundCapacity;
            objectArray[n10] = object2 = Long.valueOf(l14);
            object2 = "Background %s logging rate:%f, capacity:%d";
            ((AndroidLogger)object).debug((String)object2, objectArray);
        }
    }

    public void changeRate(boolean bl2) {
        synchronized (this) {
            long l10;
            block11: {
                block10: {
                    double d10;
                    if (bl2) {
                        d10 = this.mForegroundRate;
                    } else {
                        d10 = this.mBackgroundRate;
                    }
                    this.mRate = d10;
                    if (!bl2) break block10;
                    l10 = this.mForegroundCapacity;
                    break block11;
                }
                l10 = this.mBackgroundCapacity;
            }
            this.mCapacity = l10;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean check(PerfMetric object) {
        synchronized (this) {
            object = this.mClock;
            object = ((Clock)object).getTime();
            Object object2 = this.mLastTimeTokenConsumed;
            long l10 = ((Timer)object2).getDurationMicros((Timer)object);
            double d10 = l10;
            double d11 = this.mRate;
            d10 *= d11;
            d11 = MICROS_IN_A_SECOND;
            l10 = (long)(d10 /= d11);
            long l11 = 0L;
            d11 = 0.0;
            l10 = Math.max(l11, l10);
            long l12 = this.mTokenCount + l10;
            l10 = this.mCapacity;
            this.mTokenCount = l10 = Math.min(l12, l10);
            long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l13 > 0) {
                l11 = 1L;
                d11 = Double.MIN_VALUE;
                this.mTokenCount = l10 -= l11;
                this.mLastTimeTokenConsumed = object;
                return true;
            }
            boolean bl2 = this.isLogcatEnabled;
            if (bl2) {
                object = logger;
                object2 = "Exceeded log rate limit, dropping the log.";
                ((AndroidLogger)object).warn((String)object2);
            }
            return false;
        }
    }

    public long getBackgroundCapacity() {
        return this.mBackgroundCapacity;
    }

    public double getBackgroundRate() {
        return this.mBackgroundRate;
    }

    public long getForegroundCapacity() {
        return this.mForegroundCapacity;
    }

    public double getForegroundRate() {
        return this.mForegroundRate;
    }

    public double getRate() {
        return this.mRate;
    }

    public void setRate(double d10) {
        this.mRate = d10;
    }
}

