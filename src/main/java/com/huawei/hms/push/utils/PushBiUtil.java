/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class PushBiUtil {
    public static String reportEntry(Context context, String string2) {
        return HiAnalyticsClient.reportEntry(context, string2, 50101300);
    }

    public static void reportExit(Context context, String string2, ResponseErrorCode responseErrorCode) {
        String string3 = responseErrorCode.getTransactionId();
        int n10 = responseErrorCode.getStatusCode();
        int n11 = responseErrorCode.getErrorCode();
        HiAnalyticsClient.reportExit(context, string2, string3, n10, n11, 50101300);
    }

    public static void reportExit(Context context, String string2, String string3, int n10) {
        int n11 = Status.SUCCESS.getStatusCode();
        HiAnalyticsClient.reportExit(context, string2, string3, n11, n10, 50101300);
    }

    public static void reportExit(Context context, String string2, String string3, ErrorEnum errorEnum) {
        int n10 = Status.SUCCESS.getStatusCode();
        int n11 = errorEnum.getExternalCode();
        HiAnalyticsClient.reportExit(context, string2, string3, n10, n11, 50101300);
    }
}

