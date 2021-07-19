/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch$1;
import com.google.common.base.Ticker;
import java.util.concurrent.TimeUnit;

public final class Stopwatch {
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;

    public Stopwatch() {
        Ticker ticker;
        this.ticker = ticker = Ticker.systemTicker();
    }

    public Stopwatch(Ticker ticker) {
        this.ticker = ticker = (Ticker)Preconditions.checkNotNull(ticker, "ticker");
    }

    private static String abbreviate(TimeUnit object) {
        int[] nArray = Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new AssertionError();
                throw object;
            }
            case 7: {
                return "d";
            }
            case 6: {
                return "h";
            }
            case 5: {
                return "min";
            }
            case 4: {
                return "s";
            }
            case 3: {
                return "ms";
            }
            case 2: {
                return "\u03bcs";
            }
            case 1: 
        }
        return "ns";
    }

    private static TimeUnit chooseUnit(long l10) {
        long l11;
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long l12 = timeUnit.convert(l10, timeUnit2);
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            return timeUnit;
        }
        timeUnit = TimeUnit.HOURS;
        l12 = timeUnit.convert(l10, timeUnit2);
        long l14 = l12 - l11;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object > 0) {
            return timeUnit;
        }
        timeUnit = TimeUnit.MINUTES;
        l12 = timeUnit.convert(l10, timeUnit2);
        long l15 = l12 - l11;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object > 0) {
            return timeUnit;
        }
        timeUnit = TimeUnit.SECONDS;
        l12 = timeUnit.convert(l10, timeUnit2);
        long l16 = l12 - l11;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object > 0) {
            return timeUnit;
        }
        timeUnit = TimeUnit.MILLISECONDS;
        l12 = timeUnit.convert(l10, timeUnit2);
        long l17 = l12 - l11;
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object > 0) {
            return timeUnit;
        }
        timeUnit = TimeUnit.MICROSECONDS;
        long l18 = (l10 = timeUnit.convert(l10, timeUnit2)) - l11;
        Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object2 > 0) {
            return timeUnit;
        }
        return timeUnit2;
    }

    public static Stopwatch createStarted() {
        Stopwatch stopwatch = new Stopwatch();
        return stopwatch.start();
    }

    public static Stopwatch createStarted(Ticker ticker) {
        Stopwatch stopwatch = new Stopwatch(ticker);
        return stopwatch.start();
    }

    public static Stopwatch createUnstarted() {
        Stopwatch stopwatch = new Stopwatch();
        return stopwatch;
    }

    public static Stopwatch createUnstarted(Ticker ticker) {
        Stopwatch stopwatch = new Stopwatch(ticker);
        return stopwatch;
    }

    private long elapsedNanos() {
        long l10;
        boolean bl2 = this.isRunning;
        if (bl2) {
            Ticker ticker = this.ticker;
            l10 = ticker.read();
            long l11 = this.startTick;
            l10 -= l11;
            l11 = this.elapsedNanos;
            l10 += l11;
        } else {
            l10 = this.elapsedNanos;
        }
        return l10;
    }

    public long elapsed(TimeUnit timeUnit) {
        long l10 = this.elapsedNanos();
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        return timeUnit.convert(l10, timeUnit2);
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public Stopwatch reset() {
        this.elapsedNanos = 0L;
        this.isRunning = false;
        return this;
    }

    public Stopwatch start() {
        long l10;
        boolean bl2 = this.isRunning;
        boolean bl3 = true;
        Preconditions.checkState(bl2 ^ bl3, "This stopwatch is already running.");
        this.isRunning = bl3;
        this.startTick = l10 = this.ticker.read();
        return this;
    }

    public Stopwatch stop() {
        long l10 = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        long l11 = this.elapsedNanos;
        long l12 = this.startTick;
        this.elapsedNanos = l11 += (l10 -= l12);
        return this;
    }

    public String toString() {
        long l10 = this.elapsedNanos();
        TimeUnit timeUnit = Stopwatch.chooseUnit(l10);
        double d10 = l10;
        double d11 = TimeUnit.NANOSECONDS.convert(1L, timeUnit);
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Platform.formatCompact4Digits(d10 /= d11);
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        string2 = Stopwatch.abbreviate(timeUnit);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

