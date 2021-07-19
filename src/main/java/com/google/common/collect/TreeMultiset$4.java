/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;

public class TreeMultiset$4 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BoundType boundType;
        int n12 = BoundType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$collect$BoundType = nArray;
        try {
            boundType = BoundType.OPEN;
            n11 = boundType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$collect$BoundType;
            boundType = BoundType.CLOSED;
            n11 = boundType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

