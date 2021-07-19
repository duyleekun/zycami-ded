/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.FunctionEvent$1;

public final class FunctionEvent
extends Enum {
    private static final /* synthetic */ FunctionEvent[] $VALUES;
    public static final /* enum */ FunctionEvent BACK_CENTER;
    public static final int BACK_CENTER_CODE = 0;
    public static final /* enum */ FunctionEvent BACK_HEAD;
    public static final int BACK_HEAD_CODE = 1;

    static {
        FunctionEvent functionEvent;
        FunctionEvent functionEvent2;
        BACK_CENTER = functionEvent2 = new FunctionEvent("BACK_CENTER", 0);
        int n10 = 1;
        BACK_HEAD = functionEvent = new FunctionEvent("BACK_HEAD", n10);
        FunctionEvent[] functionEventArray = new FunctionEvent[2];
        functionEventArray[0] = functionEvent2;
        functionEventArray[n10] = functionEvent;
        $VALUES = functionEventArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FunctionEvent() {
        void var2_-1;
        void var1_-1;
    }

    public static FunctionEvent from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            return BACK_CENTER;
        }
        return BACK_HEAD;
    }

    public static int to(FunctionEvent functionEvent) {
        int[] nArray = FunctionEvent$1.$SwitchMap$com$zhiyun$protocol$constants$FunctionEvent;
        int n10 = functionEvent.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            return 0;
        }
        return n11;
    }

    public static FunctionEvent valueOf(String string2) {
        return Enum.valueOf(FunctionEvent.class, string2);
    }

    public static FunctionEvent[] values() {
        return (FunctionEvent[])$VALUES.clone();
    }
}

