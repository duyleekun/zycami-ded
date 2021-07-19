/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

public final class DecodeJob$RunReason
extends Enum {
    public static final /* enum */ DecodeJob$RunReason DECODE_DATA;
    public static final /* enum */ DecodeJob$RunReason INITIALIZE;
    public static final /* enum */ DecodeJob$RunReason SWITCH_TO_SOURCE_SERVICE;
    private static final /* synthetic */ DecodeJob$RunReason[] a;

    static {
        DecodeJob$RunReason decodeJob$RunReason;
        DecodeJob$RunReason decodeJob$RunReason2;
        DecodeJob$RunReason decodeJob$RunReason3;
        INITIALIZE = decodeJob$RunReason3 = new DecodeJob$RunReason("INITIALIZE", 0);
        int n10 = 1;
        SWITCH_TO_SOURCE_SERVICE = decodeJob$RunReason2 = new DecodeJob$RunReason("SWITCH_TO_SOURCE_SERVICE", n10);
        int n11 = 2;
        DECODE_DATA = decodeJob$RunReason = new DecodeJob$RunReason("DECODE_DATA", n11);
        DecodeJob$RunReason[] decodeJob$RunReasonArray = new DecodeJob$RunReason[3];
        decodeJob$RunReasonArray[0] = decodeJob$RunReason3;
        decodeJob$RunReasonArray[n10] = decodeJob$RunReason2;
        decodeJob$RunReasonArray[n11] = decodeJob$RunReason;
        a = decodeJob$RunReasonArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DecodeJob$RunReason() {
        void var2_-1;
        void var1_-1;
    }

    public static DecodeJob$RunReason valueOf(String string2) {
        return Enum.valueOf(DecodeJob$RunReason.class, string2);
    }

    public static DecodeJob$RunReason[] values() {
        return (DecodeJob$RunReason[])a.clone();
    }
}

