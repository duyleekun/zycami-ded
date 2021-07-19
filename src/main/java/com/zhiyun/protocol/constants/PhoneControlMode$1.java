/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.PhoneControlMode;

public class PhoneControlMode$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PhoneControlMode phoneControlMode;
        int n12 = PhoneControlMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode = nArray;
        try {
            phoneControlMode = PhoneControlMode.BEGIN;
            n11 = phoneControlMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode;
            phoneControlMode = PhoneControlMode.END;
            n11 = phoneControlMode.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

