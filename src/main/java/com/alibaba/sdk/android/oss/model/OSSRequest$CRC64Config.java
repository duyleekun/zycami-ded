/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public final class OSSRequest$CRC64Config
extends Enum {
    private static final /* synthetic */ OSSRequest$CRC64Config[] $VALUES;
    public static final /* enum */ OSSRequest$CRC64Config NO;
    public static final /* enum */ OSSRequest$CRC64Config NULL;
    public static final /* enum */ OSSRequest$CRC64Config YES;

    static {
        OSSRequest$CRC64Config oSSRequest$CRC64Config;
        OSSRequest$CRC64Config oSSRequest$CRC64Config2;
        OSSRequest$CRC64Config oSSRequest$CRC64Config3;
        NULL = oSSRequest$CRC64Config3 = new OSSRequest$CRC64Config("NULL", 0);
        int n10 = 1;
        YES = oSSRequest$CRC64Config2 = new OSSRequest$CRC64Config("YES", n10);
        int n11 = 2;
        NO = oSSRequest$CRC64Config = new OSSRequest$CRC64Config("NO", n11);
        OSSRequest$CRC64Config[] oSSRequest$CRC64ConfigArray = new OSSRequest$CRC64Config[3];
        oSSRequest$CRC64ConfigArray[0] = oSSRequest$CRC64Config3;
        oSSRequest$CRC64ConfigArray[n10] = oSSRequest$CRC64Config2;
        oSSRequest$CRC64ConfigArray[n11] = oSSRequest$CRC64Config;
        $VALUES = oSSRequest$CRC64ConfigArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OSSRequest$CRC64Config() {
        void var2_-1;
        void var1_-1;
    }

    public static OSSRequest$CRC64Config valueOf(String string2) {
        return Enum.valueOf(OSSRequest$CRC64Config.class, string2);
    }

    public static OSSRequest$CRC64Config[] values() {
        return (OSSRequest$CRC64Config[])$VALUES.clone();
    }
}

