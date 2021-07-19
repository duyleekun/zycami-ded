/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.VID;

public class VID$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$VID;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        VID vID;
        int n12 = VID.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$VID = nArray;
        try {
            vID = VID.CANON;
            n11 = vID.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$VID;
            vID = VID.SONY;
            n11 = vID.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$VID;
            vID = VID.NIKON;
            n11 = vID.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$VID;
            vID = VID.GENERAL;
            n11 = vID.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

