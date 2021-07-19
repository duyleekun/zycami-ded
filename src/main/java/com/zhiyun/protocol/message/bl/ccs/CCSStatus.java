/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus$a;

public final class CCSStatus
extends Enum {
    public static final /* enum */ CCSStatus GEN_ERROR;
    public static final /* enum */ CCSStatus NO_ERROR;
    public static final /* enum */ CCSStatus WAIT;
    private static final byte a = 0;
    private static final byte b = 1;
    private static final byte c = 2;
    private static final /* synthetic */ CCSStatus[] d;

    static {
        CCSStatus cCSStatus;
        CCSStatus cCSStatus2;
        CCSStatus cCSStatus3;
        NO_ERROR = cCSStatus3 = new CCSStatus("NO_ERROR", 0);
        int n10 = 1;
        GEN_ERROR = cCSStatus2 = new CCSStatus("GEN_ERROR", n10);
        int n11 = 2;
        WAIT = cCSStatus = new CCSStatus("WAIT", n11);
        CCSStatus[] cCSStatusArray = new CCSStatus[3];
        cCSStatusArray[0] = cCSStatus3;
        cCSStatusArray[n10] = cCSStatus2;
        cCSStatusArray[n11] = cCSStatus;
        d = cCSStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CCSStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static CCSStatus toStatus(byte by2) {
        if (by2 != 0) {
            byte by3 = 1;
            if (by2 != by3) {
                return WAIT;
            }
            return GEN_ERROR;
        }
        return NO_ERROR;
    }

    public static byte toValue(CCSStatus cCSStatus) {
        byte by2;
        int[] nArray = CCSStatus$a.a;
        int by22 = cCSStatus.ordinal();
        byte by3 = nArray[by22];
        if (by3 != (by2 = 1)) {
            byte by4 = 2;
            if (by3 != by4) {
                return by4;
            }
            return by2;
        }
        return 0;
    }

    public static CCSStatus valueOf(String string2) {
        return Enum.valueOf(CCSStatus.class, string2);
    }

    public static CCSStatus[] values() {
        return (CCSStatus[])d.clone();
    }
}

