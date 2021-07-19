/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediapipe;

public final class ZYMPController$resultType
extends Enum {
    private static final /* synthetic */ ZYMPController$resultType[] a;
    public static final /* enum */ ZYMPController$resultType gestures;
    public static final /* enum */ ZYMPController$resultType hands;
    public static final /* enum */ ZYMPController$resultType palms;

    static {
        ZYMPController$resultType zYMPController$resultType;
        ZYMPController$resultType zYMPController$resultType2;
        ZYMPController$resultType zYMPController$resultType3;
        gestures = zYMPController$resultType3 = new ZYMPController$resultType("gestures", 0);
        int n10 = 1;
        palms = zYMPController$resultType2 = new ZYMPController$resultType("palms", n10);
        int n11 = 2;
        hands = zYMPController$resultType = new ZYMPController$resultType("hands", n11);
        ZYMPController$resultType[] zYMPController$resultTypeArray = new ZYMPController$resultType[3];
        zYMPController$resultTypeArray[0] = zYMPController$resultType3;
        zYMPController$resultTypeArray[n10] = zYMPController$resultType2;
        zYMPController$resultTypeArray[n11] = zYMPController$resultType;
        a = zYMPController$resultTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ZYMPController$resultType() {
        void var2_-1;
        void var1_-1;
    }

    public static ZYMPController$resultType valueOf(String string2) {
        return Enum.valueOf(ZYMPController$resultType.class, string2);
    }

    public static ZYMPController$resultType[] values() {
        return (ZYMPController$resultType[])a.clone();
    }
}

