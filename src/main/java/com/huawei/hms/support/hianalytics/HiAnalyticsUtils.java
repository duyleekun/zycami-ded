/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.huawei.hianalytics.process.HiAnalyticsManager
 *  com.huawei.hianalytics.util.HiAnalyticTools
 */
package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.a;
import com.huawei.hms.stats.b;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HiAnalyticsUtils {
    public static final Object c;
    public static final Object d;
    public static HiAnalyticsUtils e;
    public int a = 0;
    public boolean b;

    static {
        Object object;
        c = object = new Object();
        d = object = new Object();
    }

    public HiAnalyticsUtils() {
        boolean bl2;
        this.b = bl2 = com.huawei.hms.stats.c.a();
    }

    public static LinkedHashMap a(Map map) {
        boolean bl2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            Object v10 = map.get(string2);
            linkedHashMap.put(string2, v10);
        }
        return linkedHashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HiAnalyticsUtils getInstance() {
        Object object = c;
        synchronized (object) {
            HiAnalyticsUtils hiAnalyticsUtils = e;
            if (hiAnalyticsUtils != null) return e;
            e = hiAnalyticsUtils = new HiAnalyticsUtils();
            return e;
        }
    }

    public static String versionCodeToName(String string2) {
        int n10;
        String string3 = ".";
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        String string4 = "";
        if (n11 == 0 && ((n11 = string2.length()) == (n10 = 8) || (n11 = string2.length()) == (n10 = 9))) {
            try {
                Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {}
            StringBuilder stringBuilder = new StringBuilder();
            n10 = 0;
            String string5 = null;
            int n12 = string2.length() + -7;
            string5 = string2.substring(0, n12);
            n10 = Integer.parseInt(string5);
            stringBuilder.append(n10);
            stringBuilder.append(string3);
            n10 = string2.length() + -7;
            n12 = string2.length() + -5;
            string5 = string2.substring(n10, n12);
            n10 = Integer.parseInt(string5);
            stringBuilder.append(n10);
            stringBuilder.append(string3);
            n10 = string2.length() + -5;
            n12 = string2.length() + -3;
            string5 = string2.substring(n10, n12);
            n10 = Integer.parseInt(string5);
            stringBuilder.append(n10);
            stringBuilder.append(string3);
            int n13 = string2.length() + -3;
            string2 = string2.substring(n13);
            int n14 = Integer.parseInt(string2);
            stringBuilder.append(n14);
            return stringBuilder.toString();
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context) {
        Object object = d;
        synchronized (object) {
            int n10 = this.a;
            int n11 = 60;
            int n12 = 1;
            if (n10 < n11) {
                this.a = n10 += n12;
            } else {
                n10 = 0;
                this.a = 0;
                n11 = (int)(this.b ? 1 : 0);
                if (n11 == 0) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    com.huawei.hms.stats.b.a(context, 0);
                    com.huawei.hms.stats.b.a(context, n12);
                }
            }
            return;
        }
    }

    public void enableLog() {
        String string2 = "HiAnalyticsUtils";
        String string3 = "Enable Log";
        HMSLog.i(string2, string3);
        boolean bl2 = this.b;
        if (!bl2) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            string3 = "cp needs to pass in the context, this method is not supported";
            HMSLog.i(string2, string3);
        }
    }

    public void enableLog(Context context) {
        String string2 = "HiAnalyticsUtils";
        String string3 = "Enable Log";
        HMSLog.i(string2, string3);
        boolean bl2 = this.b;
        if (!bl2) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog((Context)context);
        }
    }

    public boolean getInitFlag() {
        boolean bl2 = this.b;
        if (!bl2) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag((String)"hms_config_tag");
    }

    public boolean hasError(Context context) {
        return com.huawei.hms.stats.a.c(context);
    }

    public void onBuoyEvent(Context context, String string2, String string3) {
        boolean bl2 = this.hasError(context);
        if (bl2) {
            return;
        }
        if (context != null) {
            this.onEvent2(context, string2, string3);
        }
    }

    public void onEvent(Context context, String string2, Map map) {
        boolean bl2 = this.hasError(context);
        if (bl2) {
            return;
        }
        if (map != null && !(bl2 = map.isEmpty()) && context != null && (bl2 = this.getInitFlag())) {
            bl2 = this.b;
            int n10 = 1;
            if (!bl2) {
                LinkedHashMap linkedHashMap = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(0, string2, linkedHashMap);
                map = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(n10, string2, (LinkedHashMap)map);
            } else {
                LinkedHashMap linkedHashMap = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(context, 0, string2, linkedHashMap);
                map = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(context, n10, string2, (LinkedHashMap)map);
            }
            this.a(context);
        }
    }

    public void onEvent2(Context context, String string2, String string3) {
        boolean bl2 = this.hasError(context);
        if (bl2) {
            return;
        }
        if (context != null && (bl2 = this.getInitFlag())) {
            bl2 = this.b;
            if (!bl2) {
                HmsHiAnalyticsUtils.onEvent(context, string2, string3);
            } else {
                com.huawei.hms.stats.b.a(context, string2, string3);
            }
        }
    }

    public void onNewEvent(Context context, String string2, Map map) {
        boolean bl2 = this.hasError(context);
        if (bl2) {
            return;
        }
        if (map != null && !(bl2 = map.isEmpty()) && context != null && (bl2 = this.getInitFlag())) {
            bl2 = this.b;
            int n10 = 1;
            if (!bl2) {
                LinkedHashMap linkedHashMap = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(0, string2, linkedHashMap);
                map = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(n10, string2, (LinkedHashMap)map);
            } else {
                LinkedHashMap linkedHashMap = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(context, 0, string2, linkedHashMap);
                map = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(context, n10, string2, (LinkedHashMap)map);
            }
            this.a(context);
        }
    }

    public void onNewEvent(Context context, String string2, Map map, int n10) {
        int n11 = this.hasError(context);
        if (n11 != 0) {
            return;
        }
        if (n10 != 0 && n10 != (n11 = 1)) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
            return;
        }
        if (map != null && (n11 = (int)(map.isEmpty() ? 1 : 0)) == 0 && context != null && (n11 = (int)(this.getInitFlag() ? 1 : 0)) != 0) {
            n11 = (int)(this.b ? 1 : 0);
            if (n11 == 0) {
                map = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(n10, string2, (LinkedHashMap)map);
            } else {
                map = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(context, n10, string2, (LinkedHashMap)map);
            }
            this.a(context);
        }
    }

    public void onReport(Context object, String string2, Map map) {
        boolean bl2 = this.hasError((Context)object);
        if (bl2) {
            return;
        }
        if (map != null && !(bl2 = map.isEmpty()) && object != null && (bl2 = this.getInitFlag())) {
            bl2 = this.b;
            int n10 = 1;
            if (!bl2) {
                object = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(0, string2, (LinkedHashMap)object);
                object = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(n10, string2, (LinkedHashMap)object);
                HmsHiAnalyticsUtils.onReport();
            } else {
                LinkedHashMap linkedHashMap = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(object, 0, string2, linkedHashMap);
                map = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(object, n10, string2, (LinkedHashMap)map);
                com.huawei.hms.stats.b.a(object, 0);
                com.huawei.hms.stats.b.a(object, n10);
            }
        }
    }

    public void onReport(Context object, String string2, Map map, int n10) {
        int n11 = this.hasError((Context)object);
        if (n11 != 0) {
            return;
        }
        if (n10 != 0 && n10 != (n11 = 1)) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
            return;
        }
        if (map != null && (n11 = (int)(map.isEmpty() ? 1 : 0)) == 0 && object != null && (n11 = (int)(this.getInitFlag() ? 1 : 0)) != 0) {
            n11 = (int)(this.b ? 1 : 0);
            if (n11 == 0) {
                object = HiAnalyticsUtils.a(map);
                HmsHiAnalyticsUtils.onEvent(n10, string2, (LinkedHashMap)object);
                HmsHiAnalyticsUtils.onReport();
            } else {
                map = HiAnalyticsUtils.a(map);
                com.huawei.hms.stats.b.a(object, n10, string2, (LinkedHashMap)map);
                com.huawei.hms.stats.b.a(object, n10);
            }
        }
    }
}

