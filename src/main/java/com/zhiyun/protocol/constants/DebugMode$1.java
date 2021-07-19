/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.DebugMode;

public class DebugMode$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$DebugMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DebugMode debugMode;
        int n12 = DebugMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$DebugMode = nArray;
        try {
            debugMode = DebugMode.SUB_POWER;
            n11 = debugMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$DebugMode;
            debugMode = DebugMode.IMU_DEBUG;
            n11 = debugMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$DebugMode;
            debugMode = DebugMode.IMU_COMPENSATE;
            n11 = debugMode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$DebugMode;
            debugMode = DebugMode.NORMAL;
            n11 = debugMode.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

