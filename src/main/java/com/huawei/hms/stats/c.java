/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

public class c {
    public static final Object a;
    public static boolean b = false;
    public static boolean c = false;

    static {
        Object object;
        a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a() {
        Object object = a;
        synchronized (object) {
            boolean bl2 = b;
            if (!bl2) {
                String string2;
                String string3 = "com.huawei.hianalytics.process.HiAnalyticsInstance";
                boolean bl3 = false;
                CharSequence charSequence = null;
                boolean bl4 = true;
                try {
                    Class.forName(string3);
                    bl2 = bl4;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    string3 = "HianalyticsExist";
                    string2 = "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.";
                    HMSLog.i(string3, string2);
                    bl2 = false;
                    string3 = null;
                }
                string2 = "com.huawei.hms.hatool.HmsHiAnalyticsUtils";
                try {
                    Class.forName(string2);
                    bl3 = bl4;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    string2 = "HianalyticsExist";
                    String string4 = "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.";
                    HMSLog.i(string2, string4);
                }
                if (bl2 && !bl3) {
                    c = bl4;
                }
                b = bl4;
                string3 = "HianalyticsExist";
                charSequence = new StringBuilder();
                String string5 = "hianalytics exist: ";
                charSequence.append(string5);
                bl4 = c;
                charSequence.append(bl4);
                charSequence = charSequence.toString();
                HMSLog.i(string3, (String)charSequence);
            }
            return c;
        }
    }
}

