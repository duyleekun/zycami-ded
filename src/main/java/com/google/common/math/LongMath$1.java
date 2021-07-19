/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import java.math.RoundingMode;

public class LongMath$1 {
    public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        RoundingMode roundingMode;
        int n12 = RoundingMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$java$math$RoundingMode = nArray;
        try {
            roundingMode = RoundingMode.UNNECESSARY;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.DOWN;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.FLOOR;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.UP;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.CEILING;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.HALF_DOWN;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.HALF_UP;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$java$math$RoundingMode;
            roundingMode = RoundingMode.HALF_EVEN;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

