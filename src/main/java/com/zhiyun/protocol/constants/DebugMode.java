/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.DebugMode$1;

public final class DebugMode
extends Enum {
    private static final /* synthetic */ DebugMode[] $VALUES;
    public static final /* enum */ DebugMode IMU_COMPENSATE;
    private static final int IMU_COMPENSATE_CODE = 3;
    public static final /* enum */ DebugMode IMU_DEBUG;
    private static final int IMU_DEBUG_CODE = 2;
    public static final /* enum */ DebugMode NORMAL;
    private static final int NORMAL_CODE = 0;
    public static final /* enum */ DebugMode SUB_POWER;
    private static final int SUB_POWER_CODE = 1;

    static {
        DebugMode debugMode;
        DebugMode debugMode2;
        DebugMode debugMode3;
        DebugMode debugMode4;
        NORMAL = debugMode4 = new DebugMode("NORMAL", 0);
        int n10 = 1;
        SUB_POWER = debugMode3 = new DebugMode("SUB_POWER", n10);
        int n11 = 2;
        IMU_DEBUG = debugMode2 = new DebugMode("IMU_DEBUG", n11);
        int n12 = 3;
        IMU_COMPENSATE = debugMode = new DebugMode("IMU_COMPENSATE", n12);
        DebugMode[] debugModeArray = new DebugMode[4];
        debugModeArray[0] = debugMode4;
        debugModeArray[n10] = debugMode3;
        debugModeArray[n11] = debugMode2;
        debugModeArray[n12] = debugMode;
        $VALUES = debugModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DebugMode() {
        void var2_-1;
        void var1_-1;
    }

    public static DebugMode from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return NORMAL;
                }
                return IMU_COMPENSATE;
            }
            return IMU_DEBUG;
        }
        return SUB_POWER;
    }

    public static int to(DebugMode debugMode) {
        int[] nArray = DebugMode$1.$SwitchMap$com$zhiyun$protocol$constants$DebugMode;
        int n10 = debugMode.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2) && n10 != (n11 = 3)) {
            return 0;
        }
        return n11;
    }

    public static DebugMode valueOf(String string2) {
        return Enum.valueOf(DebugMode.class, string2);
    }

    public static DebugMode[] values() {
        return (DebugMode[])$VALUES.clone();
    }
}

