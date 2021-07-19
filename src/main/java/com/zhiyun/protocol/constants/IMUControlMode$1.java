/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.IMUControlMode;

public class IMUControlMode$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        IMUControlMode iMUControlMode;
        int n12 = IMUControlMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode = nArray;
        try {
            iMUControlMode = IMUControlMode.CAPTURE_1;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CAPTURE_2;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CAPTURE_3;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CAPTURE_4;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CAPTURE_5;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CAPTURE_6;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CALCULATION;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CALIBRATION;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$IMUControlMode;
            iMUControlMode = IMUControlMode.CLEAR;
            n11 = iMUControlMode.ordinal();
            nArray[n11] = n10 = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

