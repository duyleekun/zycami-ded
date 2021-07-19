/*
 * Decompiled with CFR 0.151.
 */
package org.ahocorasick.interval;

import org.ahocorasick.interval.IntervalNode$Direction;

public class IntervalNode$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        IntervalNode$Direction intervalNode$Direction;
        int n12 = IntervalNode$Direction.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            intervalNode$Direction = IntervalNode$Direction.LEFT;
            n11 = intervalNode$Direction.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            intervalNode$Direction = IntervalNode$Direction.RIGHT;
            n11 = intervalNode$Direction.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

