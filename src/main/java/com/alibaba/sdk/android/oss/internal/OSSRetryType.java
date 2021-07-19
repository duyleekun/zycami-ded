/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

public final class OSSRetryType
extends Enum {
    private static final /* synthetic */ OSSRetryType[] $VALUES;
    public static final /* enum */ OSSRetryType OSSRetryTypeShouldFixedTimeSkewedAndRetry;
    public static final /* enum */ OSSRetryType OSSRetryTypeShouldNotRetry;
    public static final /* enum */ OSSRetryType OSSRetryTypeShouldRetry;

    static {
        OSSRetryType oSSRetryType;
        OSSRetryType oSSRetryType2;
        OSSRetryType oSSRetryType3;
        OSSRetryTypeShouldNotRetry = oSSRetryType3 = new OSSRetryType("OSSRetryTypeShouldNotRetry", 0);
        int n10 = 1;
        OSSRetryTypeShouldRetry = oSSRetryType2 = new OSSRetryType("OSSRetryTypeShouldRetry", n10);
        int n11 = 2;
        OSSRetryTypeShouldFixedTimeSkewedAndRetry = oSSRetryType = new OSSRetryType("OSSRetryTypeShouldFixedTimeSkewedAndRetry", n11);
        OSSRetryType[] oSSRetryTypeArray = new OSSRetryType[3];
        oSSRetryTypeArray[0] = oSSRetryType3;
        oSSRetryTypeArray[n10] = oSSRetryType2;
        oSSRetryTypeArray[n11] = oSSRetryType;
        $VALUES = oSSRetryTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OSSRetryType() {
        void var2_-1;
        void var1_-1;
    }

    public static OSSRetryType valueOf(String string2) {
        return Enum.valueOf(OSSRetryType.class, string2);
    }

    public static OSSRetryType[] values() {
        return (OSSRetryType[])$VALUES.clone();
    }
}

