/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class f {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context object) {
        String string2 = "unknown";
        if (object == null) {
            return string2;
        }
        PackageManager packageManager = object.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            String string3 = object.getPackageName();
            packageInfo = packageManager.getPackageInfo(string3, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        if (packageInfo == null) return string2;
        String string4 = packageInfo.packageName;
        if (string4 != null) return string4;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int b(Context object) {
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        PackageManager packageManager = object.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            String string2 = object.getPackageName();
            packageInfo = packageManager.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        if (packageInfo == null) return n10;
        int n11 = packageInfo.versionCode;
        if (n11 != 0) return n11;
        return n10;
    }
}

