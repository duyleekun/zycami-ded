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
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;

public class HiAnalyticsUtil {
    private static final Object a;
    private static HiAnalyticsUtil b;
    private static HiAnalyticsUtils c;

    static {
        Object object;
        a = object = new Object();
    }

    private String a(Context object, String string2) {
        String string3 = object.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("01|");
        stringBuilder.append("");
        String string4 = "|";
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        object = Util.getAppId(object);
        stringBuilder.append((String)object);
        stringBuilder.append(string4);
        stringBuilder.append(50200300);
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HiAnalyticsUtil getInstance() {
        Object object = a;
        synchronized (object) {
            Object object2 = b;
            if (object2 != null) return b;
            object2 = new HiAnalyticsUtil();
            b = object2;
            c = object2 = HiAnalyticsUtils.getInstance();
            return b;
        }
    }

    public static Map getMapFromForegroundResponseHeader(ResponseHeader object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object == null) {
            return hashMap;
        }
        String string2 = ((ResponseHeader)object).getTransactionId();
        hashMap.put("transId", string2);
        string2 = ((ResponseHeader)object).getActualAppID();
        hashMap.put("appid", string2);
        string2 = ((ResponseHeader)object).getSrvName();
        hashMap.put("service", string2);
        string2 = ((ResponseHeader)object).getApiName();
        hashMap.put("apiName", string2);
        string2 = ((ResponseHeader)object).getPkgName();
        hashMap.put("package", string2);
        string2 = String.valueOf(((ResponseHeader)object).getStatusCode());
        hashMap.put("statusCode", string2);
        string2 = String.valueOf(((ResponseHeader)object).getErrorCode());
        hashMap.put("result", string2);
        object = ((ResponseHeader)object).getErrorReason();
        hashMap.put("errorReason", object);
        object = String.valueOf(System.currentTimeMillis());
        hashMap.put("callTime", object);
        hashMap.put("baseVersion", "5.2.0.300");
        return hashMap;
    }

    public static Map getMapFromRequestHeader(ResponseHeader object) {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object == null) {
            return hashMap;
        }
        Object object2 = ((ResponseHeader)object).getTransactionId();
        hashMap.put("transId", object2);
        object2 = ((ResponseHeader)object).getActualAppID();
        hashMap.put("appid", object2);
        object2 = ((ResponseHeader)object).getSrvName();
        String string2 = "service";
        hashMap.put(string2, object2);
        object2 = ((ResponseHeader)object).getApiName();
        int n11 = TextUtils.isEmpty((CharSequence)object2);
        if (n11 == 0 && (n11 = ((String[])(object2 = object2.split(string2 = "\\."))).length) >= (n10 = 2)) {
            n11 = 1;
            object2 = object2[n11];
            string2 = "apiName";
            hashMap.put(string2, object2);
        }
        object2 = ((ResponseHeader)object).getPkgName();
        hashMap.put("package", object2);
        object2 = String.valueOf(((ResponseHeader)object).getStatusCode());
        hashMap.put("statusCode", object2);
        object2 = String.valueOf(((ResponseHeader)object).getErrorCode());
        hashMap.put("result", object2);
        object = ((ResponseHeader)object).getErrorReason();
        hashMap.put("errorReason", object);
        object = String.valueOf(System.currentTimeMillis());
        hashMap.put("callTime", object);
        hashMap.put("baseVersion", "5.2.0.300");
        return hashMap;
    }

    public static String versionCodeToName(String string2) {
        return HiAnalyticsUtils.versionCodeToName(string2);
    }

    public Map getMapForBi(Context object, String string2) {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object2 = string2.split("\\.");
        int n11 = ((String[])object2).length;
        if (n11 >= (n10 = 2)) {
            n11 = 0;
            String string3 = object2[0];
            n10 = 1;
            object2 = object2[n10];
            String string4 = Util.getAppId(object);
            string2 = TransactionIdCreater.getId(string4, string2);
            String string5 = "transId";
            hashMap.put(string5, string2);
            hashMap.put("appid", string4);
            hashMap.put("service", string3);
            hashMap.put("apiName", object2);
            object = object.getPackageName();
            hashMap.put("package", object);
            hashMap.put("version", "5.2.0.300");
            long l10 = System.currentTimeMillis();
            object = String.valueOf(l10);
            string2 = "callTime";
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public Map getMapFromForegroundRequestHeader(RequestHeader object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object == null) {
            return hashMap;
        }
        String string2 = ((RequestHeader)object).getTransactionId();
        hashMap.put("transId", string2);
        string2 = ((RequestHeader)object).getActualAppID();
        hashMap.put("appid", string2);
        string2 = ((RequestHeader)object).getSrvName();
        hashMap.put("service", string2);
        string2 = ((RequestHeader)object).getApiName();
        hashMap.put("apiName", string2);
        object = ((RequestHeader)object).getPkgName();
        hashMap.put("package", object);
        object = String.valueOf(System.currentTimeMillis());
        hashMap.put("callTime", object);
        hashMap.put("baseVersion", "5.2.0.300");
        return hashMap;
    }

    public Map getMapFromRequestHeader(RequestHeader object) {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object == null) {
            return hashMap;
        }
        Object object2 = ((RequestHeader)object).getTransactionId();
        hashMap.put("transId", object2);
        object2 = ((RequestHeader)object).getActualAppID();
        hashMap.put("appid", object2);
        object2 = ((RequestHeader)object).getSrvName();
        String string2 = "service";
        hashMap.put(string2, object2);
        object2 = ((RequestHeader)object).getApiName();
        int n11 = TextUtils.isEmpty((CharSequence)object2);
        if (n11 == 0 && (n11 = ((String[])(object2 = object2.split(string2 = "\\."))).length) >= (n10 = 2)) {
            n11 = 1;
            object2 = object2[n11];
            string2 = "apiName";
            hashMap.put(string2, object2);
        }
        object = ((RequestHeader)object).getPkgName();
        hashMap.put("package", object);
        object = String.valueOf(System.currentTimeMillis());
        hashMap.put("callTime", object);
        hashMap.put("baseVersion", "5.2.0.300");
        return hashMap;
    }

    public boolean hasError() {
        boolean bl2 = SystemUtils.isChinaROM();
        if (!bl2) {
            HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
            return true;
        }
        return false;
    }

    public boolean hasError(Context context) {
        return c.hasError(context);
    }

    public void onBuoyEvent(Context context, String string2, String string3) {
        c.onBuoyEvent(context, string2, string3);
    }

    public void onEvent(Context context, String string2, String string3) {
        if (context != null) {
            string3 = this.a(context, string3);
            this.onEvent2(context, string2, string3);
        }
    }

    public void onEvent(Context context, String string2, Map map) {
        c.onEvent(context, string2, map);
    }

    public void onEvent2(Context context, String string2, String string3) {
        c.onEvent2(context, string2, string3);
    }

    public void onNewEvent(Context context, String string2, Map map) {
        c.onNewEvent(context, string2, map);
    }
}

