/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    public static String parseMilliSecondToString(Long l10) {
        SimpleDateFormat simpleDateFormat;
        if (l10 == null) {
            return null;
        }
        String string2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        try {
            simpleDateFormat = new SimpleDateFormat(string2);
        }
        catch (Exception exception) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", exception);
            return null;
        }
        return simpleDateFormat.format(l10);
    }

    public static long parseUtcToMillisecond(String string2) {
        Object object = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", (Locale)object);
        object = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone((TimeZone)object);
        object = ".";
        int n10 = string2.indexOf((String)object);
        String string3 = string2.substring(0, n10);
        int n11 = string2.indexOf((String)object);
        string2 = string2.substring(n11);
        object = new StringBuilder();
        string2 = string2.substring(0, 4);
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("Z");
        string2 = ((StringBuilder)object).toString();
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        return simpleDateFormat.parse(string2).getTime();
    }
}

