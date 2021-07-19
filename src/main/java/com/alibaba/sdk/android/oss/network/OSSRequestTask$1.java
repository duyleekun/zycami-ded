/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.common.HttpMethod;

public class OSSRequestTask$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        HttpMethod httpMethod;
        int n12 = HttpMethod.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = nArray;
        try {
            httpMethod = HttpMethod.POST;
            n11 = httpMethod.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;
            httpMethod = HttpMethod.PUT;
            n11 = httpMethod.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;
            httpMethod = HttpMethod.GET;
            n11 = httpMethod.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;
            httpMethod = HttpMethod.HEAD;
            n11 = httpMethod.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;
            httpMethod = HttpMethod.DELETE;
            n11 = httpMethod.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

