/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.IMUControlMode$1;

public final class IMUControlMode
extends Enum {
    private static final /* synthetic */ IMUControlMode[] $VALUES;
    public static final /* enum */ IMUControlMode CALCULATION;
    private static final int CALCULATION_CODE = 7;
    public static final /* enum */ IMUControlMode CALIBRATION;
    private static final int CALIBRATION_CODE = 8;
    public static final /* enum */ IMUControlMode CAPTURE_1;
    private static final int CAPTURE_1_CODE = 1;
    public static final /* enum */ IMUControlMode CAPTURE_2;
    private static final int CAPTURE_2_CODE = 2;
    public static final /* enum */ IMUControlMode CAPTURE_3;
    private static final int CAPTURE_3_CODE = 3;
    public static final /* enum */ IMUControlMode CAPTURE_4;
    private static final int CAPTURE_4_CODE = 4;
    public static final /* enum */ IMUControlMode CAPTURE_5;
    private static final int CAPTURE_5_CODE = 5;
    public static final /* enum */ IMUControlMode CAPTURE_6;
    private static final int CAPTURE_6_CODE = 6;
    public static final /* enum */ IMUControlMode CLEAR;
    private static final int CLEAR_CODE;

    static {
        IMUControlMode iMUControlMode;
        IMUControlMode iMUControlMode2;
        IMUControlMode iMUControlMode3;
        IMUControlMode iMUControlMode4;
        IMUControlMode iMUControlMode5;
        IMUControlMode iMUControlMode6;
        IMUControlMode iMUControlMode7;
        IMUControlMode iMUControlMode8;
        IMUControlMode iMUControlMode9;
        CLEAR = iMUControlMode9 = new IMUControlMode("CLEAR", 0);
        int n10 = 1;
        CAPTURE_1 = iMUControlMode8 = new IMUControlMode("CAPTURE_1", n10);
        int n11 = 2;
        CAPTURE_2 = iMUControlMode7 = new IMUControlMode("CAPTURE_2", n11);
        int n12 = 3;
        CAPTURE_3 = iMUControlMode6 = new IMUControlMode("CAPTURE_3", n12);
        int n13 = 4;
        CAPTURE_4 = iMUControlMode5 = new IMUControlMode("CAPTURE_4", n13);
        CAPTURE_5 = iMUControlMode4 = new IMUControlMode("CAPTURE_5", 5);
        CAPTURE_6 = iMUControlMode3 = new IMUControlMode("CAPTURE_6", 6);
        CALCULATION = iMUControlMode2 = new IMUControlMode("CALCULATION", 7);
        int n14 = 8;
        CALIBRATION = iMUControlMode = new IMUControlMode("CALIBRATION", n14);
        IMUControlMode[] iMUControlModeArray = new IMUControlMode[9];
        iMUControlModeArray[0] = iMUControlMode9;
        iMUControlModeArray[n10] = iMUControlMode8;
        iMUControlModeArray[n11] = iMUControlMode7;
        iMUControlModeArray[n12] = iMUControlMode6;
        iMUControlModeArray[n13] = iMUControlMode5;
        iMUControlModeArray[5] = iMUControlMode4;
        iMUControlModeArray[6] = iMUControlMode3;
        iMUControlModeArray[7] = iMUControlMode2;
        iMUControlModeArray[n14] = iMUControlMode;
        $VALUES = iMUControlModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private IMUControlMode() {
        void var2_-1;
        void var1_-1;
    }

    public static IMUControlMode from(int n10) {
        switch (n10) {
            default: {
                return CLEAR;
            }
            case 8: {
                return CALIBRATION;
            }
            case 7: {
                return CALCULATION;
            }
            case 6: {
                return CAPTURE_6;
            }
            case 5: {
                return CAPTURE_5;
            }
            case 4: {
                return CAPTURE_4;
            }
            case 3: {
                return CAPTURE_3;
            }
            case 2: {
                return CAPTURE_2;
            }
            case 1: 
        }
        return CAPTURE_1;
    }

    public static int to(IMUControlMode iMUControlMode) {
        int[] nArray = IMUControlMode$1.$SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
        int n10 = iMUControlMode.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return 0;
            }
            case 8: {
                return 8;
            }
            case 7: {
                return 7;
            }
            case 6: {
                return 6;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: 
        }
        return 1;
    }

    public static IMUControlMode valueOf(String string2) {
        return Enum.valueOf(IMUControlMode.class, string2);
    }

    public static IMUControlMode[] values() {
        return (IMUControlMode[])$VALUES.clone();
    }
}

