/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import d.j.a.f.a;
import java.io.IOException;
import java.io.InputStream;

public class AGCUtils {
    public static String a(Context object) {
        String string2;
        String string3;
        String string4;
        block11: {
            block12: {
                int n10;
                string4 = "In getMetaDataAppId, Failed to read meta data for the AppID.";
                Object object2 = object.getPackageManager();
                string3 = "";
                string2 = "AGCUtils";
                if (object2 == null) {
                    HMSLog.e(string2, "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
                    return string3;
                }
                try {
                    object = object.getPackageName();
                    n10 = 128;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    HMSLog.e(string2, string4);
                    return string3;
                }
                object = object2.getPackageInfo((String)object, n10);
                object = ((PackageInfo)object).applicationInfo;
                if (object == null) break block11;
                object = ((ApplicationInfo)object).metaData;
                if (object == null) break block11;
                object2 = "com.huawei.hms.client.appid";
                object = object.get((String)object2);
                if (object == null) break block11;
                object = String.valueOf(object);
                object2 = "appid=";
                boolean n11 = ((String)object).startsWith((String)object2);
                if (!n11) break block12;
                int n12 = 6;
                object = ((String)object).substring(n12);
            }
            return object;
        }
        HMSLog.e(string2, string4);
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context object, String string2) {
        Throwable throwable2;
        InputStream inputStream;
        block8: {
            String string3;
            String string4;
            block6: {
                String string5 = "Get ";
                string4 = "";
                string3 = "AGCUtils";
                Object object2 = a.a((Context)object);
                inputStream = null;
                try {
                    try {
                        object = object.getResources();
                        object = object.getAssets();
                        String string6 = "agconnect-services.json";
                        inputStream = object.open(string6);
                        ((a)object2).j(inputStream);
                        object = ((a)object2).g(string2);
                        break block6;
                    }
                    catch (NullPointerException nullPointerException) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(string2);
                        string5 = " with AGConnectServicesConfig failed: ";
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(nullPointerException);
                        object = ((StringBuilder)object2).toString();
                        HMSLog.e(string3, (String)object);
                    }
                    catch (IOException iOException) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(string2);
                        string5 = " failed: ";
                        ((StringBuilder)object2).append(string5);
                        ((StringBuilder)object2).append(iOException);
                        object = ((StringBuilder)object2).toString();
                        HMSLog.e(string3, (String)object);
                    }
                }
                catch (Throwable throwable2) {
                    break block8;
                }
                object = string4;
            }
            IOUtils.closeQuietly(inputStream);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("The ");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" is null.");
            object = ((StringBuilder)object).toString();
            HMSLog.e(string3, (String)object);
            return string4;
        }
        IOUtils.closeQuietly(inputStream);
        throw throwable2;
    }

    public static String b(Context object) {
        String string2;
        String string3;
        String string4;
        block11: {
            block12: {
                int n10;
                string4 = "In getMetaDataCpId, Failed to read meta data for the CpId.";
                Object object2 = object.getPackageManager();
                string3 = "";
                string2 = "AGCUtils";
                if (object2 == null) {
                    HMSLog.e(string2, "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
                    return string3;
                }
                try {
                    object = object.getPackageName();
                    n10 = 128;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    HMSLog.e(string2, string4);
                    return string3;
                }
                object = object2.getPackageInfo((String)object, n10);
                object = ((PackageInfo)object).applicationInfo;
                if (object == null) break block11;
                object = ((ApplicationInfo)object).metaData;
                if (object == null) break block11;
                object2 = "com.huawei.hms.client.cpid";
                object = object.get((String)object2);
                if (object == null) break block11;
                object = String.valueOf(object);
                object2 = "cpid=";
                boolean n11 = ((String)object).startsWith((String)object2);
                if (!n11) break block12;
                int n12 = 5;
                object = ((String)object).substring(n12);
            }
            return object;
        }
        HMSLog.i(string2, string4);
        return string3;
    }

    public static boolean c(Context object) {
        String string2 = object.getPackageName();
        object = HMSPackageManager.getInstance(object).getHMSPackageName();
        return string2.equals(object);
    }

    public static String getAppId(Context context) {
        boolean bl2 = AGCUtils.c(context);
        String string2 = "client/app_id";
        if (bl2) {
            return AGCUtils.a(context, string2);
        }
        bl2 = false;
        String string3 = null;
        Object object = a.a(context);
        try {
            string3 = ((a)object).g(string2);
        }
        catch (NullPointerException nullPointerException) {
            object = "AGCUtils";
            String string4 = "Get appId with AGConnectServicesConfig failed";
            HMSLog.e((String)object, string4);
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            return string3;
        }
        string3 = AGCUtils.a(context);
        bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            return string3;
        }
        return AGCUtils.a(context, string2);
    }

    public static String getCpId(Context context) {
        boolean bl2 = AGCUtils.c(context);
        String string2 = "client/cp_id";
        if (bl2) {
            return AGCUtils.a(context, string2);
        }
        bl2 = false;
        String string3 = null;
        Object object = a.a(context);
        try {
            string3 = ((a)object).g(string2);
        }
        catch (NullPointerException nullPointerException) {
            object = "AGCUtils";
            String string4 = "Get cpid with AGConnectServicesConfig failed";
            HMSLog.e((String)object, string4);
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            return string3;
        }
        string3 = AGCUtils.b(context);
        bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            return string3;
        }
        return AGCUtils.a(context, string2);
    }
}

