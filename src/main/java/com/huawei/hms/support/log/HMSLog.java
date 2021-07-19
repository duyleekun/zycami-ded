/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;

public class HMSLog {
    public static final a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public static String a(Context object) {
        Object object2 = object.getPackageManager();
        String string2 = "HMS-[unknown-version]";
        if (object2 != null) {
            int n10;
            try {
                object = object.getPackageName();
                n10 = 16384;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            object = object2.getPackageInfo((String)object, n10);
            object2 = new StringBuilder();
            String string3 = "HMS-";
            ((StringBuilder)object2).append(string3);
            string3 = object.versionName;
            ((StringBuilder)object2).append(string3);
            string3 = "(";
            ((StringBuilder)object2).append(string3);
            int n11 = object.versionCode;
            ((StringBuilder)object2).append(n11);
            object = ")";
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        return string2;
    }

    public static void d(String string2, String string3) {
        a.a(3, string2, string3);
    }

    public static void e(String string2, long l10, String string3) {
        a a10 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        a10.a(6, string2, string4);
    }

    public static void e(String string2, long l10, String string3, Throwable throwable) {
        a a10 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        a10.b(6, string2, string4, throwable);
    }

    public static void e(String string2, String string3) {
        a.a(6, string2, string3);
    }

    public static void e(String string2, String string3, Throwable throwable) {
        a.b(6, string2, string3, throwable);
    }

    public static void i(String string2, String string3) {
        a.a(4, string2, string3);
    }

    public static void init(Context object, int n10, String string2) {
        a a10 = a;
        a10.a((Context)object, n10, string2);
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "============================================================================";
        stringBuilder.append(string3);
        char c10 = '\n';
        stringBuilder.append(c10);
        stringBuilder.append("====== ");
        object = HMSLog.a(object);
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append(string3);
        object = stringBuilder.toString();
        a10.a(string2, (String)object);
    }

    public static boolean isErrorEnable() {
        return a.a(6);
    }

    public static boolean isInfoEnable() {
        return a.a(4);
    }

    public static boolean isWarnEnable() {
        return a.a(5);
    }

    public static void w(String string2, String string3) {
        a.a(5, string2, string3);
    }
}

