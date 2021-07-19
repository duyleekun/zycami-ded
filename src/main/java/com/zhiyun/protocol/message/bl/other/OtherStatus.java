/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.other;

import com.zhiyun.protocol.message.bl.other.OtherStatus$a;

public final class OtherStatus
extends Enum {
    public static final /* enum */ OtherStatus MD5_ERROR;
    public static final /* enum */ OtherStatus NONE_ERROR;
    public static final /* enum */ OtherStatus UPDATE_ERROR;
    public static final /* enum */ OtherStatus UPDATE_STARTED;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final /* synthetic */ OtherStatus[] e;

    static {
        OtherStatus otherStatus;
        OtherStatus otherStatus2;
        OtherStatus otherStatus3;
        OtherStatus otherStatus4;
        NONE_ERROR = otherStatus4 = new OtherStatus("NONE_ERROR", 0);
        int n10 = 1;
        MD5_ERROR = otherStatus3 = new OtherStatus("MD5_ERROR", n10);
        int n11 = 2;
        UPDATE_ERROR = otherStatus2 = new OtherStatus("UPDATE_ERROR", n11);
        int n12 = 3;
        UPDATE_STARTED = otherStatus = new OtherStatus("UPDATE_STARTED", n12);
        OtherStatus[] otherStatusArray = new OtherStatus[4];
        otherStatusArray[0] = otherStatus4;
        otherStatusArray[n10] = otherStatus3;
        otherStatusArray[n11] = otherStatus2;
        otherStatusArray[n12] = otherStatus;
        e = otherStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OtherStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static OtherStatus from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return NONE_ERROR;
                }
                return UPDATE_STARTED;
            }
            return UPDATE_ERROR;
        }
        return MD5_ERROR;
    }

    public static int to(OtherStatus otherStatus) {
        int[] nArray = OtherStatus$a.a;
        int n10 = otherStatus.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2) && n10 != (n11 = 3)) {
            return 0;
        }
        return n11;
    }

    public static OtherStatus valueOf(String string2) {
        return Enum.valueOf(OtherStatus.class, string2);
    }

    public static OtherStatus[] values() {
        return (OtherStatus[])e.clone();
    }
}

