/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSiteStats$RateLimitPeriod;
import com.google.common.flogger.LogSiteStats$StatsMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class LogSiteStats {
    private static final LogSiteStats$StatsMap map;
    private final AtomicLong invocationCount;
    private final AtomicLong lastTimestampNanos;
    private final AtomicInteger skippedLogStatements;

    static {
        LogSiteStats$StatsMap logSiteStats$StatsMap;
        map = logSiteStats$StatsMap = new LogSiteStats$StatsMap();
    }

    public LogSiteStats() {
        Number number;
        this.invocationCount = number = new AtomicLong();
        this.lastTimestampNanos = number = new AtomicLong();
        this.skippedLogStatements = number;
    }

    public static LogSiteStats getStatsForKey(Object object) {
        return map.getStatsForKey(object);
    }

    public static LogSiteStats$RateLimitPeriod newRateLimitPeriod(int n10, TimeUnit timeUnit) {
        LogSiteStats$RateLimitPeriod logSiteStats$RateLimitPeriod = new LogSiteStats$RateLimitPeriod(n10, timeUnit, null);
        return logSiteStats$RateLimitPeriod;
    }

    public boolean checkLastTimestamp(long l10, LogSiteStats$RateLimitPeriod logSiteStats$RateLimitPeriod) {
        AtomicLong atomicLong;
        int n10;
        long l11;
        long l12;
        AtomicLong atomicLong2 = this.lastTimestampNanos;
        long l13 = atomicLong2.get();
        long l14 = LogSiteStats$RateLimitPeriod.access$100(logSiteStats$RateLimitPeriod) + l13;
        long l15 = l14 - (l12 = 0L);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object >= 0 && ((l11 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) >= 0 || (l11 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) == false) && (n10 = (atomicLong = this.lastTimestampNanos).compareAndSet(l13, l10)) != 0) {
            n10 = this.skippedLogStatements.getAndSet(0);
            LogSiteStats$RateLimitPeriod.access$200(logSiteStats$RateLimitPeriod, n10);
            return true;
        }
        this.skippedLogStatements.incrementAndGet();
        return false;
    }

    public boolean incrementAndCheckInvocationCount(int n10) {
        AtomicLong atomicLong = this.invocationCount;
        long l10 = atomicLong.getAndIncrement();
        long l11 = n10;
        long l12 = (l10 %= l11) - (l11 = 0L);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }
}

