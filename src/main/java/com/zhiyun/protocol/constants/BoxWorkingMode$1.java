/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.BoxWorkingMode;

public class BoxWorkingMode$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BoxWorkingMode boxWorkingMode;
        int n12 = BoxWorkingMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode = nArray;
        try {
            boxWorkingMode = BoxWorkingMode.SALVE;
            n11 = boxWorkingMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode;
            boxWorkingMode = BoxWorkingMode.UNCONNECTED;
            n11 = boxWorkingMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode;
            boxWorkingMode = BoxWorkingMode.HOST;
            n11 = boxWorkingMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

