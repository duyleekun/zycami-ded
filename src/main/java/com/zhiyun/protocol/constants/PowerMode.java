/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.PowerMode$1;

public final class PowerMode
extends Enum {
    private static final /* synthetic */ PowerMode[] $VALUES;
    public static final /* enum */ PowerMode OFF;
    public static final int OFF_CODE = 0;
    public static final /* enum */ PowerMode ON;
    public static final int ON_CODE = 1;

    static {
        PowerMode powerMode;
        PowerMode powerMode2;
        ON = powerMode2 = new PowerMode("ON", 0);
        int n10 = 1;
        OFF = powerMode = new PowerMode("OFF", n10);
        PowerMode[] powerModeArray = new PowerMode[2];
        powerModeArray[0] = powerMode2;
        powerModeArray[n10] = powerMode;
        $VALUES = powerModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PowerMode() {
        void var2_-1;
        void var1_-1;
    }

    public static PowerMode from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            return OFF;
        }
        return ON;
    }

    public static int to(PowerMode powerMode) {
        int[] nArray = PowerMode$1.$SwitchMap$com$zhiyun$protocol$constants$PowerMode;
        int n10 = powerMode.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            return 0;
        }
        return n11;
    }

    public static PowerMode valueOf(String string2) {
        return Enum.valueOf(PowerMode.class, string2);
    }

    public static PowerMode[] values() {
        return (PowerMode[])$VALUES.clone();
    }
}

