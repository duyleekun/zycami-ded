/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.alibaba.sdk.android.oss.common.utils;

import android.os.Build;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;

public class VersionInfoUtils {
    private static String userAgent;

    private static String getSystemInfo() {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("(");
        CharSequence charSequence2 = System.getProperty("os.name");
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("/Android ");
        String string2 = Build.VERSION.RELEASE;
        ((StringBuilder)charSequence2).append(string2);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("/");
        charSequence2 = new StringBuilder();
        string2 = Build.MODEL;
        String string3 = "utf-8";
        string2 = HttpUtil.urlEncode(string2, string3);
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append(";");
        string2 = HttpUtil.urlEncode(Build.ID, string3);
        ((StringBuilder)charSequence2).append(string2);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(")");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence2 = new StringBuilder();
        string2 = "user agent : ";
        ((StringBuilder)charSequence2).append(string2);
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        OSSLog.logDebug((String)charSequence2);
        boolean bl2 = OSSUtils.isEmptyString((String)charSequence);
        if (bl2) {
            charSequence = System.getProperty("http.agent");
            charSequence2 = "[^\\p{ASCII}]";
            string2 = "?";
            charSequence = ((String)charSequence).replaceAll((String)charSequence2, string2);
        }
        return charSequence;
    }

    public static String getUserAgent(String string2) {
        String string3;
        CharSequence charSequence = userAgent;
        boolean bl2 = OSSUtils.isEmptyString((String)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("aliyun-sdk-android/");
            string3 = VersionInfoUtils.getVersion();
            ((StringBuilder)charSequence).append(string3);
            string3 = VersionInfoUtils.getSystemInfo();
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            userAgent = charSequence;
        }
        if (bl2 = OSSUtils.isEmptyString(string2)) {
            return userAgent;
        }
        charSequence = new StringBuilder();
        string3 = userAgent;
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("/");
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public static String getVersion() {
        return "2.9.4";
    }
}

