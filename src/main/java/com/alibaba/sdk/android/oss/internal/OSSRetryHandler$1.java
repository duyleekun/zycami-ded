/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.OSSRetryType;

public class OSSRetryHandler$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        OSSRetryType oSSRetryType;
        int n10 = OSSRetryType.values().length;
        int[] nArray = new int[n10];
        $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType = nArray;
        try {
            oSSRetryType = OSSRetryType.OSSRetryTypeShouldRetry;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        int n11 = oSSRetryType.ordinal();
        int n12 = 1;
        nArray[n11] = n12;
    }
}

