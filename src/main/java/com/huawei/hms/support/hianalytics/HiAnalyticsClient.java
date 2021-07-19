/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.hianalytics.a;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsClient
extends a {
    public static String reportEntry(Context context, String string2) {
        String string3 = Util.getAppId(context);
        return HiAnalyticsClient.reportEntry(context, string2, string3, 0);
    }

    public static String reportEntry(Context context, String string2, int n10) {
        String string3 = Util.getAppId(context);
        return HiAnalyticsClient.reportEntry(context, string2, string3, n10);
    }

    public static String reportEntry(Context context, String object, String string2, int n10) {
        String string3 = TransactionIdCreater.getId(string2, (String)object);
        object = a.getMapForBi(context, (String)object);
        object.put("appid", string2);
        object.put("transId", string3);
        object.put("direction", "req");
        string2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n10));
        object.put("version", string2);
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        object.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_KIT_API_CALLED", (Map)object);
        return string3;
    }

    public static void reportExit(Context context, String string2, String string3, int n10, int n11) {
        String string4 = Util.getAppId(context);
        HiAnalyticsClient.reportExit(context, string2, string3, string4, n10, n11, 0);
    }

    public static void reportExit(Context context, String string2, String string3, int n10, int n11, int n12) {
        String string4 = Util.getAppId(context);
        HiAnalyticsClient.reportExit(context, string2, string3, string4, n10, n11, n12);
    }

    public static void reportExit(Context context, String object, String string2, String string3, int n10, int n11, int n12) {
        object = a.getMapForBi(context, (String)object);
        object.put("appid", string3);
        object.put("transId", string2);
        object.put("direction", "rsp");
        string2 = String.valueOf(n10);
        object.put("statusCode", string2);
        string2 = String.valueOf(n11);
        object.put("result", string2);
        string2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n12));
        object.put("version", string2);
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        object.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_KIT_API_CALLED", (Map)object);
    }
}

