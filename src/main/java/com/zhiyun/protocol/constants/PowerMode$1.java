/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.PowerMode;

public class PowerMode$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$PowerMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PowerMode powerMode;
        int n12 = PowerMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$PowerMode = nArray;
        try {
            powerMode = PowerMode.ON;
            n11 = powerMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$PowerMode;
            powerMode = PowerMode.OFF;
            n11 = powerMode.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

