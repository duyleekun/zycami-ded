/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.hianalytics.a;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class b
extends a {
    public static void a(Context context, ResponseHeader object, String string2) {
        HiAnalyticsUtil.getInstance();
        object = HiAnalyticsUtil.getMapFromRequestHeader((ResponseHeader)object);
        String string3 = "direction";
        String string4 = "rsp";
        object.put(string3, string4);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = HiAnalyticsUtil.versionCodeToName(string2);
            string3 = "version";
            object.put(string3, string2);
        }
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        object.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_API_CALLED", (Map)object);
    }

    public static void a(Context context, String string2, String string3, String string4, String string5) {
        Map map = a.getMapForBi(context, string2);
        String string6 = "appid";
        map.put(string6, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            string4 = TransactionIdCreater.getId(string3, string2);
        }
        map.put("transId", string4);
        string2 = "direction";
        string3 = "req";
        map.put(string2, string3);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string5);
        if (!bl3) {
            string2 = HiAnalyticsUtil.versionCodeToName(string5);
            string3 = "version";
            map.put(string3, string2);
        }
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        map.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_API_CALLED", map);
    }
}

