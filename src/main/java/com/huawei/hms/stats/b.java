/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.huawei.hianalytics.process.HiAnalyticsInstance
 */
package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

public class b {
    public static HiAnalyticsInstance a;

    public static HiAnalyticsInstance a(Context context) {
        context = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        a = context;
        return context;
    }

    public static void a(Context context, int n10) {
        if ((context = b.a(context)) != null) {
            context = a;
            context.onReport(n10);
        }
    }

    public static void a(Context context, int n10, String string2, LinkedHashMap linkedHashMap) {
        if ((context = b.a(context)) != null) {
            context = a;
            context.onEvent(n10, string2, linkedHashMap);
        }
    }

    public static void a(Context context, String string2, String string3) {
        HiAnalyticsInstance hiAnalyticsInstance = b.a(context);
        if (hiAnalyticsInstance != null) {
            hiAnalyticsInstance = a;
            hiAnalyticsInstance.onEvent(context, string2, string3);
        }
    }
}

