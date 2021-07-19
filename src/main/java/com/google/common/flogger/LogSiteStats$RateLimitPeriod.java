/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSiteStats$1;
import com.google.common.flogger.util.Checks;
import java.util.concurrent.TimeUnit;

public final class LogSiteStats$RateLimitPeriod {
    private final int n;
    private int skipCount;
    private final TimeUnit unit;

    private LogSiteStats$RateLimitPeriod(int n10, TimeUnit object) {
        int n11;
        this.skipCount = n11 = -1;
        if (n10 > 0) {
            TimeUnit timeUnit;
            this.n = n10;
            this.unit = timeUnit = (TimeUnit)((Object)Checks.checkNotNull(object, "time unit"));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time period must be positive: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        super(string2);
        throw object;
    }

    public /* synthetic */ LogSiteStats$RateLimitPeriod(int n10, TimeUnit timeUnit, LogSiteStats$1 logSiteStats$1) {
        this(n10, timeUnit);
    }

    public static /* synthetic */ long access$100(LogSiteStats$RateLimitPeriod logSiteStats$RateLimitPeriod) {
        return logSiteStats$RateLimitPeriod.toNanos();
    }

    public static /* synthetic */ void access$200(LogSiteStats$RateLimitPeriod logSiteStats$RateLimitPeriod, int n10) {
        logSiteStats$RateLimitPeriod.setSkipCount(n10);
    }

    private void setSkipCount(int n10) {
        this.skipCount = n10;
    }

    private long toNanos() {
        TimeUnit timeUnit = this.unit;
        long l10 = this.n;
        return timeUnit.toNanos(l10);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof LogSiteStats$RateLimitPeriod;
        boolean bl2 = false;
        if (n10 != 0) {
            TimeUnit timeUnit;
            object = (LogSiteStats$RateLimitPeriod)object;
            n10 = this.n;
            int n11 = ((LogSiteStats$RateLimitPeriod)object).n;
            if (n10 == n11 && (timeUnit = this.unit) == (object = ((LogSiteStats$RateLimitPeriod)object).unit)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.n * 37;
        int n11 = this.unit.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int c10 = this.n;
        stringBuilder.append(c10);
        stringBuilder.append(' ');
        Object object = this.unit;
        stringBuilder.append(object);
        int n10 = this.skipCount;
        if (n10 > 0) {
            object = " [skipped: ";
            stringBuilder.append((String)object);
            int n11 = this.skipCount;
            stringBuilder.append(n11);
            char c11 = ']';
            stringBuilder.append(c11);
        }
        return stringBuilder.toString();
    }
}

