/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 */
package com.huawei.hms.stats;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;

public class a {
    public static int a;
    public static final Object b;

    static {
        Object object;
        b = object = new Object();
    }

    public static boolean a(Context object) {
        String string2;
        block8: {
            string2 = "AnalyticsSwitchHolder";
            if (object == null) {
                HMSLog.e(string2, "In getBiIsReportSetting, context is null.");
                return false;
            }
            Object object2 = object.getPackageManager();
            if (object2 != null) {
                object = object.getPackageName();
                int n10 = 128;
                object = object2.getPackageInfo((String)object, n10);
                object = object.applicationInfo;
                if (object == null) break block8;
                object = object.metaData;
                if (object == null) break block8;
                object2 = "com.huawei.hms.client.bireport.setting";
                try {
                    return object.getBoolean((String)object2);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object = "In getBiIsReportSetting, Failed to read meta data bi report setting.";
                    HMSLog.e(string2, (String)object);
                }
            }
        }
        HMSLog.i(string2, "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    public static boolean b(Context object) {
        String string2;
        block8: {
            string2 = "AnalyticsSwitchHolder";
            if (object == null) {
                HMSLog.e(string2, "In getBiSetting, context is null.");
                return false;
            }
            Object object2 = object.getPackageManager();
            if (object2 != null) {
                object = object.getPackageName();
                int n10 = 128;
                object = object2.getPackageInfo((String)object, n10);
                object = object.applicationInfo;
                if (object == null) break block8;
                object = object.metaData;
                if (object == null) break block8;
                object2 = "com.huawei.hms.client.bi.setting";
                try {
                    return object.getBoolean((String)object2);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object = "In getBiSetting, Failed to read meta data bisetting.";
                    HMSLog.e(string2, (String)object);
                }
            }
        }
        HMSLog.i(string2, "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean c(Context object) {
        Object object2 = b;
        synchronized (object2) {
            int n10;
            int n11 = a;
            int n12 = 1;
            if (n11 == 0) {
                if (object == null) {
                    return n12 != 0;
                }
                n11 = (int)(com.huawei.hms.stats.a.a(object) ? 1 : 0);
                if (n11 != 0) {
                    object = "AnalyticsSwitchHolder";
                    String string2 = "Builder->biReportSetting :true";
                    HMSLog.i((String)object, string2);
                    a = n12;
                } else {
                    n11 = (int)(com.huawei.hms.stats.a.b(object) ? 1 : 0);
                    int n13 = 2;
                    if (n11 != 0) {
                        object = "AnalyticsSwitchHolder";
                        String string3 = "Builder->biSetting :true";
                        HMSLog.i((String)object, string3);
                        a = n13;
                    } else {
                        String string4 = "CN";
                        Object object3 = GrsApp.getInstance();
                        n11 = (int)(string4.equalsIgnoreCase((String)(object3 = ((GrsApp)object3).getIssueCountryCode((Context)object))) ? 1 : 0);
                        if (n11 != 0) {
                            a = n12;
                        } else {
                            string4 = "AnalyticsSwitchHolder";
                            object3 = "not ChinaROM";
                            HMSLog.i(string4, (String)object3);
                            try {
                                object = object.getContentResolver();
                                string4 = "hw_app_analytics_state";
                                n10 = Settings.Secure.getInt((ContentResolver)object, (String)string4);
                                string4 = "AnalyticsSwitchHolder";
                                object3 = new StringBuilder();
                                String string5 = "hw_app_analytics_state value is ";
                                ((StringBuilder)object3).append(string5);
                                ((StringBuilder)object3).append(n10);
                                object3 = ((StringBuilder)object3).toString();
                                HMSLog.i(string4, (String)object3);
                                a = n10 == n12 ? n12 : n13;
                            }
                            catch (Settings.SettingNotFoundException settingNotFoundException) {
                                object = "AnalyticsSwitchHolder";
                                string4 = "Get OOBE failed";
                                HMSLog.i((String)object, string4);
                                a = n13;
                            }
                        }
                    }
                }
            }
            if ((n10 = a) == n12) return 0 != 0;
            return n12 != 0;
        }
    }
}

