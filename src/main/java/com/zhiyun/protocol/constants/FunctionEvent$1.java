/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.FunctionEvent;

public class FunctionEvent$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FunctionEvent functionEvent;
        int n12 = FunctionEvent.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent = nArray;
        try {
            functionEvent = FunctionEvent.BACK_HEAD;
            n11 = functionEvent.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$FunctionEvent;
            functionEvent = FunctionEvent.BACK_CENTER;
            n11 = functionEvent.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

