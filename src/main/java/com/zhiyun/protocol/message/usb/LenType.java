/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb;

import com.zhiyun.protocol.message.usb.LenType$a;

public final class LenType
extends Enum {
    public static final /* enum */ LenType BIT_1;
    public static final /* enum */ LenType BIT_2;
    public static final /* enum */ LenType BIT_4;
    public static final /* enum */ LenType UNKNOWN;
    private static final int a = 255;
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 3;
    private static final /* synthetic */ LenType[] e;

    static {
        LenType lenType;
        LenType lenType2;
        LenType lenType3;
        LenType lenType4;
        UNKNOWN = lenType4 = new LenType("UNKNOWN", 0);
        int n10 = 1;
        BIT_1 = lenType3 = new LenType("BIT_1", n10);
        int n11 = 2;
        BIT_2 = lenType2 = new LenType("BIT_2", n11);
        int n12 = 3;
        BIT_4 = lenType = new LenType("BIT_4", n12);
        LenType[] lenTypeArray = new LenType[4];
        lenTypeArray[0] = lenType4;
        lenTypeArray[n10] = lenType3;
        lenTypeArray[n11] = lenType2;
        lenTypeArray[n12] = lenType;
        e = lenTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LenType() {
        void var2_-1;
        void var1_-1;
    }

    public static LenType toType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return BIT_4;
            }
            return BIT_2;
        }
        return BIT_1;
    }

    public static int toValue(LenType lenType) {
        int[] nArray = LenType$a.a;
        int n10 = lenType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12 && n10 != (n11 = 3)) {
                return -1;
            }
            return n11;
        }
        return 0;
    }

    public static LenType valueOf(String string2) {
        return Enum.valueOf(LenType.class, string2);
    }

    public static LenType[] values() {
        return (LenType[])e.clone();
    }
}

