/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$Strength;

public class CacheBuilderSpec$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        LocalCache$Strength localCache$Strength;
        int n12 = LocalCache$Strength.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$cache$LocalCache$Strength = nArray;
        try {
            localCache$Strength = LocalCache$Strength.WEAK;
            n11 = localCache$Strength.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$cache$LocalCache$Strength;
            localCache$Strength = LocalCache$Strength.SOFT;
            n11 = localCache$Strength.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

