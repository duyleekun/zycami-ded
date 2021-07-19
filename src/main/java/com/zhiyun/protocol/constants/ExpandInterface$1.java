/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.ExpandInterface;

public class ExpandInterface$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ExpandInterface expandInterface;
        int n12 = ExpandInterface.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface = nArray;
        try {
            expandInterface = ExpandInterface.CLOSED;
            n11 = expandInterface.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;
            expandInterface = ExpandInterface.GENERAL;
            n11 = expandInterface.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;
            expandInterface = ExpandInterface.SONY;
            n11 = expandInterface.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;
            expandInterface = ExpandInterface.PANASONIC;
            n11 = expandInterface.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

