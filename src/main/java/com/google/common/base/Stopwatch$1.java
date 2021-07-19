/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import java.util.concurrent.TimeUnit;

public class Stopwatch$1 {
    public static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        TimeUnit timeUnit;
        int n12 = TimeUnit.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$java$util$concurrent$TimeUnit = nArray;
        try {
            timeUnit = TimeUnit.NANOSECONDS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.MICROSECONDS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.MILLISECONDS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.SECONDS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.MINUTES;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.HOURS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$util$concurrent$TimeUnit;
            timeUnit = TimeUnit.DAYS;
            n11 = timeUnit.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

