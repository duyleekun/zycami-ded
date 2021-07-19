/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

public final class SDStatus
extends Enum {
    public static final /* enum */ SDStatus PERMISSION_DENIED;
    public static final /* enum */ SDStatus SUPPORTED;
    public static final /* enum */ SDStatus UNSUPPORTED;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final /* synthetic */ SDStatus[] d;

    static {
        SDStatus sDStatus;
        SDStatus sDStatus2;
        SDStatus sDStatus3;
        UNSUPPORTED = sDStatus3 = new SDStatus("UNSUPPORTED", 0);
        int n10 = 1;
        SUPPORTED = sDStatus2 = new SDStatus("SUPPORTED", n10);
        int n11 = 2;
        PERMISSION_DENIED = sDStatus = new SDStatus("PERMISSION_DENIED", n11);
        SDStatus[] sDStatusArray = new SDStatus[3];
        sDStatusArray[0] = sDStatus3;
        sDStatusArray[n10] = sDStatus2;
        sDStatusArray[n11] = sDStatus;
        d = sDStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SDStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static SDStatus from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return UNSUPPORTED;
            }
            return PERMISSION_DENIED;
        }
        return SUPPORTED;
    }

    public static SDStatus valueOf(String string2) {
        return Enum.valueOf(SDStatus.class, string2);
    }

    public static SDStatus[] values() {
        return (SDStatus[])d.clone();
    }
}

